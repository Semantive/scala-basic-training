package com.sages.zad_5_1

object FunctionalSet {
  type Set = Int => Boolean

  def contains(s: Set, x: Int): Boolean = s(x)

  def singletonSet(x: Int): Set = _ == x

  def union(s: Set, t: Set): Set = x => s(x) || t(x)

  def intersect(s: Set, t: Set): Set = x => s(x) && t(x)

  def diff(s: Set, t: Set): Set = x => s(x) && !t(x)

  def filter(s: Set, p: Int => Boolean): Set = x => p(x) && s(x)
}

object Zad_5_1 extends App {
  import FunctionalSet._

  assert(contains(singletonSet(1), 1))
  assert(!contains(singletonSet(1), 2))

  val twoSet = union(singletonSet(1), singletonSet(2))
  assert(contains(twoSet, 1))
  assert(contains(twoSet, 2))

  val otherTwoSet = union(singletonSet(2), singletonSet(3))
  val intersectSet = intersect(twoSet, otherTwoSet)
  assert(contains(intersectSet, 2))
  assert(!contains(intersectSet, 1))
  assert(!contains(intersectSet, 3))

  val diffSet = diff(twoSet, otherTwoSet)
  assert(contains(diffSet, 1))
  assert(!contains(diffSet, 2))
  assert(!contains(diffSet, 3))

  val filterSet = filter(twoSet, _ % 2 == 0)
  assert(contains(filterSet, 2))
  assert(!contains(filterSet, 1))
}
