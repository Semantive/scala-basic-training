package com.sages.zad_7_3

import scala.collection.immutable.TreeSet

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String]) {
  override def toString: String = name + " " + surname
}

object Zad_7_3 extends App {
  val personList = Vector(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Andrzej", "Kowalski", 17, Some("andrzej.kowalski@example.com")),
    Person("Test", "Abacki", 17, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None))

  println(personList.sortBy(_.surname))
  println(personList.sortBy(p => (p.surname, p.name)))
  println(personList.sortWith { (a, b) =>
    if (a.age > b.age) true
    else if (a.age == b.age) {
      a.surname < b.surname
    } else false
  })
  println(TreeSet(personList: _*)(Ordering.by(p => (p.surname, p.name))))
}
