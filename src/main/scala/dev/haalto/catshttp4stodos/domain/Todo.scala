package dev.haalto.catshttp4stodos.domain

import io.estatico.newtype.macros.newtype
import derevo.cats._
import derevo.circe.magnolia._
import derevo.derive

object todo {

  @derive(decoder, encoder, show)
  @newtype
  case class TodoId(value: Int)

  @derive(decoder, encoder, show)
  @newtype
  case class TodoTitle(value: String)

  @derive(decoder, encoder, show)
  @newtype
  case class TodoCompleted(value: Boolean)

  @derive(decoder, encoder, show)
  case class Todo(
      id: TodoId,
      title: TodoTitle,
      completed: TodoCompleted
  )
}
