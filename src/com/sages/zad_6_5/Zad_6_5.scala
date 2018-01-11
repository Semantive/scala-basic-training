package com.sages.zad_6_5

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String])

object Zad_6_5 extends App {
  def filter(collection: Vector[Person], predicate: Person => Boolean): Vector[Person] =
    if (collection.isEmpty) collection
    else {
      val tail = filter(collection.tail, predicate)

      if (predicate(collection.head)) collection.head +: tail
      else tail
    }

  def withEmail(person: Person): Boolean = person.email.isDefined

  def over18(person: Person): Boolean = person.age >= 18

  val peopleWithEmails: Vector[Person] => Vector[Person] = filter(_, withEmail)
  val peopleOver18: Vector[Person] => Vector[Person] = filter(_, over18)

  val bothPredicates = peopleWithEmails andThen peopleOver18

  val personList = Vector(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None))

  println(filter(personList, withEmail))
  println(filter(personList, over18))
  println(bothPredicates(personList))
}
