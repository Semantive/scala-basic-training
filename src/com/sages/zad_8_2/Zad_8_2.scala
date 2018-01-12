package com.sages.zad_8_2

import scala.collection.mutable

class Config[K, V] {
  private[zad_8_2] val data = mutable.Map[K, V]()

  def get(key: K, default: V): V = data.getOrElse(key, default)

  def set(key: K, value: V): Unit = data(key) = value
}

class ConfigView[-K, +V](config: Config[K, V]) {
  def get(key: K): V = config.data(key)
}

object ConfigView {
  def apply[K, V, KSource >: K, VSource <: V](config: Config[KSource, VSource]): ConfigView[K, V] = new ConfigView[KSource, VSource](config)
}

class A
class B extends A

object Zad_8_2 extends App {
  val baseCOnfig = new Config[A, Int]()
  val a = new B
  baseCOnfig.set(a, 5)
//  val baseConfigView = new ConfigView[B, Int](baseCOnfig)
val baseConfigView2 = ConfigView[B, Int, A, Int](baseCOnfig)
val baseConfigView = new ConfigView[A, Int](baseCOnfig)
  val other: ConfigView[B, Int] = baseConfigView
  println(other.get(a))
}
