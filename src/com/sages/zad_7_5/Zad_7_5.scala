package com.sages.zad_7_5

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String]) {
  override def toString: String = name + " " + surname
}

object Zad_7_5 extends App {
  val personList = List(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Andrzej", "Kowalski", 17, Some("andrzej.kowalski@example.com")),
    Person("Test", "Abacki", 17, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None))

  def groupByAge(ageDifferenceLessThan: Int)(people: List[Person]): List[List[Person]] =
    people.groupBy(_.age / ageDifferenceLessThan).values.toList

  println(groupByAge(5)(personList))
}
