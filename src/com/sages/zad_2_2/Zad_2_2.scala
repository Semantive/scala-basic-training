package com.sages.zad_2_2

class Logger(val name: String) {

  def this(clazz: Class[_]) =
    this(clazz.getSimpleName)

  def log(message: String, level: Int = Level.info): Unit = {
    val levelText =
      if (level == Level.info) "INFO "
      else if (level == Level.error) "ERROR"
      else if (level == Level.warn) "WARN "
      else if (level == Level.debug) "DEBUG"
      else "N/A"

    println(levelText + " [" + name + "]: " + message)
  }
}

object Level {
  val error: Int = 1
  val warn: Int = 2
  val info: Int = 3
  val debug: Int = 4
}

object Zad_2_2 extends App {
  val logger = new Logger(Zad_2_2.getClass)

  logger.log("error", Level.error)
  logger.log("warn", Level.warn)
  logger.log("info", Level.info)
  logger.log("debug", Level.debug)
  logger.log("default")
}
