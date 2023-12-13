package spa.unibo.payservice

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run = PayserviceServer.run[IO]
