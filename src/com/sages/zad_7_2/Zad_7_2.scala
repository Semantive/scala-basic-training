package com.sages.zad_7_2

import scala.io.StdIn
import scala.util.Random

object Zad_7_2 extends App {
  val values = Random.shuffle(1 to 49).take(6)
  val userTypes = (1 to 6).map(_ => StdIn.readInt())

  println(values.mkString(", "))
  println(values.count(userTypes.contains))
}
