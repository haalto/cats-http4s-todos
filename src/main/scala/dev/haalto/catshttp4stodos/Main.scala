package dev.haalto.catshttp4stodos
import cats.effect.{IO, IOApp}

import dev.haalto.catshttp4stodos.Server
object Main extends IOApp.Simple {
  val run = Server.run[IO]
}
