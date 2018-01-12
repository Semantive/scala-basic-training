package com.sages.zad_8_1

import scala.collection.mutable

class Config[K, V] {
  private[this] val data = mutable.Map[K, V]()

  def get(key: K, default: V): V = data.getOrElse(key, default)

  def set(key: K, value: V): Unit = data(key) = value
}

object Zad_8_1 extends App {
  val config = new Config[String, Int]

  println(config.get("default", 1))

  config.set("other", 5)
  println(config.get("other", 0))
}
