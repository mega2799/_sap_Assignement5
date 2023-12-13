package spa.unibo.payservice

// import cats.effect.Concurrent
// import io.circe.{Encoder, Decoder}
// import org.http4s.EntityDecoder
import cats.effect.Concurrent
import cats.syntax.all.*
import io.circe.{Encoder, Decoder}
import org.http4s.*
// import org.http4s.implicits.*
// import org.http4s.client.Client
// import org.http4s.client.dsl.Http4sClientDsl
import org.http4s.circe.*
// import org.http4s.Method.*



trait Rides[F[_]]:
  def computePrice(ride: Rides.Ride): F[Double]
  def bankTransfer(ride: Rides.Ride): F[String]

object Rides: 
    def apply[F[_]](using ev: Rides[F]): Rides[F] = ev
    final case class Ride(rideID: String, escooterID : String, userID : String, start : String, end : String)
    object Ride:
        given Decoder[Ride] = Decoder.derived[Ride]
        given [F[_]: Concurrent]: EntityDecoder[F, Ride] = jsonOf
        given Encoder[Ride] = Encoder.AsObject.derived[Ride]
        given [F[_]]: EntityEncoder[F, Ride] = jsonEncoderOf
    def impl[F[_]: Concurrent]: Rides[F] = new Rides[F]:
        var FEE = 0.5
        def computePrice(ride: Rides.Ride): F[Double] = 
            val start = ride.start.split(" ")
            val end = ride.end.split(" ")
            val startHour = start(1).split(":")
            val endHour = end(1).split(":")
            val startDay = start(0).split("-")
            val endDay = end(0).split("-")
            val startYear = startDay(0).toInt
            val startMonth = startDay(1).toInt
            val startDayOfMonth = startDay(2).toInt
            val startHourOfDay = startHour(0).toInt
            val startMinute = startHour(1).toInt
            val endYear = endDay(0).toInt
            val endMonth = endDay(1).toInt
            val endDayOfMonth = endDay(2).toInt
            val endHourOfDay = endHour(0).toInt
            val endMinute = endHour(1).toInt
            val startDateTime = java.time.LocalDateTime.of(startYear, startMonth, startDayOfMonth, startHourOfDay, startMinute)
            val endDateTime = java.time.LocalDateTime.of(endYear, endMonth, endDayOfMonth, endHourOfDay, endMinute)
            val duration = java.time.Duration.between(startDateTime, endDateTime)
            val minutes = duration.toMinutes()
            val price = minutes * FEE
            Concurrent[F].pure(price)
        def bankTransfer(ride: Rides.Ride): F[String] = 
            this.computePrice(ride).map(price => "Bank transfer of " + price + "€ completed") //Some fantasy