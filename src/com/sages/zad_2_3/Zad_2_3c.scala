package com.sages.zad_2_3

object Zad_2_3c extends App {
  println("start")

  lazy val x = {
    println("Initialize x")
    "X"
  }

  println("after x")
  println(x)
  println(y)
  println("before y")

  lazy val y = {
    println("Initialize y")
    "Y"
  }
}
