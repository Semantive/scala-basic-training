package com.sages.zad_5_4

object Zad_5_4 extends App {
  def printObject(obj: Any, desc: Any => String = _.toString): Unit = {
    println(desc(obj))
  }

  printObject(1)
  printObject(2, x => "Liczba: " + x)
  // printObject(3, (x: Int) => "Liczba" + x) // incorrect
  // printObject(4, (x: Any) => x)  // incorrect

}
