package com.sages.zad_2_1

class Logger(val name: String) {

  def this(clazz: Class[_]) =
    this(clazz.getSimpleName)

  def log(message: String): Unit = {
    println(name + ": " + message)
  }
}

object Zad_2_1 extends App {
  val logger = new Logger("first")
  val second = new Logger(classOf[Logger])

  logger.log("message from first")
  second.log("message from second")
}
