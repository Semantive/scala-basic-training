package com.sages.zad_6_2

case class Person(
  name: String,
  surname: String,
  age: Int)

object Zad_6_2 extends App {
  val first = Person("Jan", "Kowalski", 22)
  val second = Person("Jan", "Nowak", 25)

  println(first)
  println(first.copy(surname = "Nowak"))
  println(first.copy(surname = "Nowak", age = 25) == second)
  println(first == second)
}
