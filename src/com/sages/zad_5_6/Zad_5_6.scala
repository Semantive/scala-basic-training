package com.sages.zad_5_6

object Zad_5_6 extends App {
  def myReverse(s: String): String =
    if (s.isEmpty) s
    else myReverse(s.tail) + s.head

  println(myReverse("Hello"))
}
