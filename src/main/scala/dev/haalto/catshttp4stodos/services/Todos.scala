package dev.haalto.catshttp4stodos.services

import cats.effect.kernel.Async
import cats.effect.kernel.Sync
import dev.haalto.catshttp4stodos.domain.todo._

trait Todos[F[_]] {
  def getTodos: F[List[Todo]]
  def getTodo(id: TodoId): F[Option[Todo]]
  def createTodo(todo: Todo): F[Todo]
  def updateTodo(id: TodoId, todo: Todo): F[Option[Todo]]
  def deleteTodo(id: TodoId): F[Option[Todo]]
}

object Todos {
  def make[F[_]: Async](): Todos[F] =
    new Todos[F] {
      def getTodos: F[List[Todo]] =
        Sync[F].delay {
          List(
            Todo(
              TodoId(1),
              TodoTitle("Todo 1"),
              TodoCompleted(false)
            )
          )
        }

      def getTodo(id: TodoId): F[Option[Todo]] = ???
      def createTodo(todo: Todo): F[Todo] = ???
      def updateTodo(id: TodoId, todo: Todo): F[Option[Todo]] = ???
      def deleteTodo(id: TodoId): F[Option[Todo]] = ???
    }
}
