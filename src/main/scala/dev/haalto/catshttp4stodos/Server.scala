package dev.haalto.catshttp4stodos

import cats.effect.Async
//import cats.syntax.all._
import com.comcast.ip4s._
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.middleware.Logger

import dev.haalto.catshttp4stodos.Routes
import dev.haalto.catshttp4stodos.services.Todos
object Server {

  def run[F[_]: Async]: F[Nothing] = {
    for {
      _ <- EmberClientBuilder.default[F].build

      httpApp = (
        Routes.todoRoutes[F](Todos.make[F]())
      ).orNotFound

      // With Middlewares in place
      finalHttpApp = Logger.httpApp(true, true)(httpApp)

      _ <-
        EmberServerBuilder
          .default[F]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(finalHttpApp)
          .build
    } yield ()
  }.useForever
}
