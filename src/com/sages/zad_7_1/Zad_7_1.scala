package com.sages.zad_7_1

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String])

object Zad_7_1 extends App {
  val personList = Vector(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None))

  val (children, adult) = personList.partition(_.age < 18)
  println(children)
  println(adult)

  val noEmail = personList.filter(_.email.isEmpty)
  println(noEmail)

  val bulkaIndex = personList.indexWhere(_.surname == "Bułka")
  println(bulkaIndex)
}
