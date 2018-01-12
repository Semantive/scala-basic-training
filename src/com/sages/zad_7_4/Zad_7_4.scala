package com.sages.zad_7_4

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String]) {
  override def toString: String = name + " " + surname
}

object Zad_7_4 extends App {
  val personList = Vector(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Andrzej", "Kowalski", 17, Some("andrzej.kowalski@example.com")),
    Person("Test", "Abacki", 17, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None))

  personList.groupBy(_.age / 10).mapValues(_.size).foreach { case (age, count) =>
    println(age * 10 + "-" + (age * 10 + 9) + ": " + count)
  }
}
