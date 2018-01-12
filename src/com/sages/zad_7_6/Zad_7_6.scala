package com.sages.zad_7_6

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String]) {
  override def toString: String = name + " " + surname
}

object Zad_7_6 extends App {
  val personList = List(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Andrzej", "Kowalski", 17, Some("andrzej.kowalski@example.com")),
    Person("Test", "Abacki", 17, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None),
    Person("Jan", "Bułka", 34, None))

  def eldest(people: List[Person]): Person =
    people.maxBy(_.age)

  def allEldest(people: List[Person]): List[Person] = {
    val one = eldest(people)
    people.filter(_.age == one.age)
  }

  println(eldest(personList))
  println(allEldest(personList))
}
