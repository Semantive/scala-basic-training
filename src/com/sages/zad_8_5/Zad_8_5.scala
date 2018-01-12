package com.sages.zad_8_5

case class Money(value: Long)

object Zad_8_5 extends App {
  implicit def longToMoney(value: Long): Money = Money(value)

  val a: Money = 53L
  val b: Money = 47L

  val list = List(a, b)

  implicit val moneyNumeric: Numeric[Money] = new Numeric[Money] {
    override def plus(x: Money, y: Money): Money = x.value + y.value

    override def minus(x: Money, y: Money): Money = x.value - y.value

    override def times(x: Money, y: Money): Money = x.value * y.value

    override def negate(x: Money): Money = -x.value

    override def fromInt(x: Int): Money = x.toLong

    override def toInt(x: Money): Int = x.value.toInt

    override def toLong(x: Money): Long = x.value

    override def toFloat(x: Money): Float = x.value.toFloat

    override def toDouble(x: Money): Double = x.value.toDouble

    override def compare(x: Money, y: Money): Int = implicitly[Numeric[Long]].compare(x.value, y.value)
  }

  println(list.sum)
}
