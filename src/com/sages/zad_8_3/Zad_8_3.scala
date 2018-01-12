package com.sages.zad_8_3

import scala.collection.mutable

trait ConfigKey

class Config[K <: ConfigKey, V] {
  private[zad_8_3] val data = mutable.Map[K, V]()

  def get(key: K, default: V): V = data.getOrElse(key, default)

  def set(key: K, value: V): Unit = data(key) = value
}

trait StringKey extends ConfigKey

trait IntKey extends ConfigKey

object Zad_8_3 extends App {
  val config = new Config[StringKey, Int]()

  config.set(new StringKey {}, 5)
  // config.set(new IntKey {}, 1)
}
