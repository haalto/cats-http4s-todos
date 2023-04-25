package dev.haalto.catshttp4stodos

import cats.effect.Sync
import cats.implicits._
import dev.haalto.catshttp4stodos.services.Todos
import org.http4s.HttpRoutes
import org.http4s.circe.CirceEntityEncoder._
import org.http4s.dsl.Http4sDsl

object Routes {

  def todoRoutes[F[_]: Sync](T: Todos[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "todos" =>
      for {
        todos <- T.getTodos
        resp <- Ok(todos)
      } yield resp
    }
  }
}
