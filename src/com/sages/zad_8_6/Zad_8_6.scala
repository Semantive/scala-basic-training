package com.sages.zad_8_6

object Zad_8_6 extends App {
  implicit class MapExtension[K, V](map: Map[K, Set[V]]) {
    def addBinding(key: K, value: V): Map[K, Set[V]] = {
      map.updated(key, map.getOrElse(key, Set()) + value)
    }

    def removeBinding(key: K, value: V): Map[K, Set[V]] = {
      map.updated(key, map.getOrElse(key, Set()) - value)
    }
  }

  val map: Map[Int, Set[Int]] = Map(1 -> Set(1, 2, 3), 2 -> Set(1, 2))

  println(map.addBinding(1, 4))
  println(map.removeBinding(2, 2))
}
