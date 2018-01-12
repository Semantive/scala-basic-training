package com.sages.zad_7_8

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String]) {
  override def toString: String = name + " " + surname
}

object Zad_7_8 extends App {
  val personList = Vector(
    Person("Jan", "Kowalski", 16, Some("jan.kowalski@example.com")),
    Person("Andrzej", "Kowalski", 17, Some("andrzej.kowalski@example.com")),
    Person("Test", "Abacki", 17, Some("jan.kowalski@example.com")),
    Person("Jan", "Nowak", 17, None),
    Person("Piotr", "Nieznany", 24, Some("email@address.com")),
    Person("Marcin", "Bułka", 34, None),
    Person("Jan", "Bułka", 34, None))

  def join(a: Vector[Person], b: Vector[Person])(condition: (Person, Person) => Boolean): Vector[(Person, Person)] =
    (for {
      first <- a.par
      second <- b
      if condition(first, second)
    } yield (first, second)).seq

  def leftJoin(a: Vector[Person], b: Vector[Person])(condition: (Person, Person) => Boolean): Vector[(Person, Option[Person])] =
    (a.par flatMap { person =>
      val joinResult = b.filter(condition(_, person)).map(p => (person, Some(p)))

      if (joinResult.nonEmpty) joinResult
      else (person, None) :: Nil
    }).seq

  println(join(personList, personList)(_.surname == _.surname))
  println(leftJoin(personList, personList.filter(_.surname == "Nieznany"))(_.surname == _.surname))
}
