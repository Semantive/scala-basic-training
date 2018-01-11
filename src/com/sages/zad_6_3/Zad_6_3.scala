package com.sages.zad_6_3

case class Person(
  name: String,
  surname: String,
  age: Int,
  email: Option[String]) {
//  override def toString: String =
//    if (email.isDefined) "Person(" + name + ", " + surname + ", " + age + ", " + email.get + ")"
//    else "email: brak danych"

//  override def toString: String =
//    email match {
//      case Some(someEmail) => "Person(" + name + ", " + surname + ", " + age + ", " + someEmail + ")"
//      case None            => "email: brak danych"
//    }

  override def toString: String =
    email.map(e => {
      "Person(" + name + ", " + surname + ", " + age + ", " + e + ")"
    }).getOrElse("email: brak danych")
}

object Zad_6_3 extends App {
  val first = Person("Jan", "Kowalski", 22, Some("email@address.com"))
  val second = Person("Jan", "Nowak", 25, None)

  println(first)
  println(second)
}
