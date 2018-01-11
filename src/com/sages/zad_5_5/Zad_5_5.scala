package com.sages.zad_5_5

object Zad_5_5 extends App {
  def foo(a: Int, b: Int): Int = a + b

  def bar(arg: (Int, Int)): Int = arg._1 + arg._2

  // println(foo((1, 2))) // incorrect
  // println(bar.apply(1, 2)) // nope
  println(bar(1, 2)) // ok
  println(bar((1, 2))) // ok

  val tupled = Function.tupled(foo _)
  val untupled = Function.untupled(bar _)

  tupled((1, 2)) // ok
  untupled.apply(1, 2) // ok
}
