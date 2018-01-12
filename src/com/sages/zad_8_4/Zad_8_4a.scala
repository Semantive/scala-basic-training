package com.sages.zad_8_4

import scala.collection.mutable

class Config[Key[_]] {
  private[this] val data = mutable.Map[Key[_], Any]()

  def get[V](key: Key[V], default: V): V = data.get(key).map(_.asInstanceOf[V]).getOrElse(default)

  def set[V](key: Key[V], value: V): Unit = data(key) = value
}

trait KeyType[V]

object Zad_8_4a extends App {
  val config = new Config[KeyType]()

  val intKey = new KeyType[Int] {}
  val stringKey = new KeyType[String] {}

  config.set(intKey, 5)
  config.set(stringKey, "string")

  println(config.get(intKey, 0))
  println(config.get(stringKey, ""))
}
