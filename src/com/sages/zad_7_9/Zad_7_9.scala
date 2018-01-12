package com.sages.zad_7_9

import scala.collection.mutable

class Cache(loadObject: Int => Any) {
  private[this] val cache = mutable.HashMap[Int, Any]()

  def get(key: Int): Any = cache.getOrElseUpdate(key, loadObject(key))
}

object Zad_7_9 extends App {
  val cache = new Cache({ key =>
    println(s"Generating $key")
    key
  })

  println(cache.get(1))
  println(cache.get(1))
  println(cache.get(2))
  println(cache.get(3))

  println(cache.get(2))
}
