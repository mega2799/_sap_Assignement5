package spa.unibo.payservice

import cats.effect.Sync
import cats.syntax.all.*
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.Request
// import cats.effect.IO
// import scala.util.parsing.json._
// import io.circe._, io.circe.parser._
import io.circe._, io.circe.parser._ //, io.circe.syntax._ , io.circe.generic.auto._





object PayserviceRoutes:

    /**
    * Utility used to parse the req body as an IO[string] and so as a string
    * @param req
    * @tparam F
    * @return String
    */
  private def parseRequestBody[F[_] : Sync](req: Request[F]) =
    req.body
      .through(fs2.text.utf8.decode)
      .compile
      .string
      // .unsafeRunSync()

  def jokeRoutes[F[_]: Sync](J: Jokes[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F]{}
    import dsl.*
    HttpRoutes.of[F] {
      case GET -> Root / "joke" =>
        for {
          joke <- J.get
          resp <- Ok(joke)
        } yield resp
    }

  def helloWorldRoutes[F[_]: Sync](H: HelloWorld[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F]{}
    import dsl.*
    HttpRoutes.of[F] {
      case GET -> Root / "hello" / name =>
        for {
          greeting <- H.hello(HelloWorld.Name(name))
          resp <- Ok(greeting)
        } yield resp
    }
  def rideRoutes[F[_]: Sync](R: Rides[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F]{}
    import dsl.*
    HttpRoutes.of[F] {
      case req @ POST -> Root / "computePrice" =>
        for {
          rideAsString <- this.parseRequestBody(req)
          ride <- decode[Rides.Ride](rideAsString).fold(
            error => Sync[F].raiseError[Rides.Ride](new Exception(error)),
            ride => Sync[F].pure(ride)
          )
          price <- R.computePrice(ride)
          resp <- Ok(price.toString)
        } yield resp
      case req @ POST -> Root / "bankTransfer" =>
        for {
          rideAsString <- this.parseRequestBody(req)
          ride <- decode[Rides.Ride](rideAsString).fold(
            error => Sync[F].raiseError[Rides.Ride](new Exception(error)),
            ride => Sync[F].pure(ride)
          )
          // ride <- req.as[Rides.Ride]
          transfer <- R.bankTransfer(ride)
          resp <- Ok(transfer)
        } yield resp
    }
