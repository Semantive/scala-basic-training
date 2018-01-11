package com.sages.zad_5_2

object Zad_5_2 extends App {
  def fizzBuzz(start: Int, end: Int)(transform: PartialFunction[Int, String]): Unit = {
    for (i <- start to end) {
      if (transform.isDefinedAt(i))
        println(transform(i))
      else
        println(i)
    }
  }

  fizzBuzz(1, 15) {
    case x if x % 3 == 0 && x % 5 == 0 => "FizzBuzz"
    case x if x % 3 == 0               => "Fizz"
    case x if x % 5 == 0               => "Buzz"
  }
}
