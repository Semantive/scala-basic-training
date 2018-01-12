package com.sages.zad_7_7

case class Point(x: Double, y: Double)

object Zad_7_7 extends App {
  val points = List(
    Point(0, 0),
    Point(1, 0),
    Point(1, 1),
    Point(0, 1))

  def distance(a: Point, b: Point): Double = {
    val x = a.x - b.x
    val y = a.y - b.y
    Math.sqrt(x * x + y * y)
  }

  def polygonalLength(points: List[Point]): Double =
    points.zip(points.tail).map((distance _).tupled).sum

  def perimeterLength(points: List[Point]) = polygonalLength(points :+ points.head)

  println(polygonalLength(points))
  println(perimeterLength(points))
}
