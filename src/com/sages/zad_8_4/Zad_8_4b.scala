package com.sages.zad_8_4

import scala.collection.mutable

trait AbstractKeyType {
  type V
}

class ConfigDependent {
  private[this] val data = mutable.Map[AbstractKeyType, Any]()

  def get(key: AbstractKeyType)(default: key.V): key.V = data.get(key).map(_.asInstanceOf[key.V]).getOrElse(default)

  def set(key: AbstractKeyType)(value: key.V): Unit = data(key) = value
}

object Zad_8_4b extends App {
  val config = new ConfigDependent()

  val intKey = new AbstractKeyType {
    override type V = Int
  }
  val stringKey = new AbstractKeyType {
    override type V = String
  }

  config.set(intKey)(5)
  config.set(stringKey)("string")

  println(config.get(intKey)(0))
  println(config.get(stringKey)(""))
}
