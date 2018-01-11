package com.sages.zad_6_4

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String])

object Zad_6_4 extends App {
  val personList = List(
    Person("Jan", "Kowalski", 22, None),
    Person("Jan", "Nowak", 25, None),
    Person("Piotr", "Nieznany", 24, None),
    Person("Marcin", "Bułka", 34, None))

  for (Person(name, surname, _, _) <- personList)
    println(name + " " + surname)
}
