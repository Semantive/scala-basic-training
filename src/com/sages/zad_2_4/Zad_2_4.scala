package com.sages.zad_2_4

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

    println(levelText + " [" + name + "]: " + message)}
}

trait LoggerSupport {
  this: Logger =>

  def debug(message: String): Unit = {
    log(message, Level.debug)
  }

  def info(message: String): Unit = {
    log(message, Level.info)
  }

  def warn(message: String): Unit = {
    log(message, Level.warn)
  }

  def error(message: String): Unit = {
    log(message, Level.error)
  }

  def error(message: String, throwable: Throwable): Unit = {
    log(message + "; " + throwable.getLocalizedMessage, Level.error)
  }
}

object Level {
  val error: Int = 1
  val warn: Int = 2
  val info: Int = 3
  val debug: Int = 4
}

object Zad_2_4 extends App {
  val logger = new Logger(Zad_2_4.getClass) with LoggerSupport

  logger.error("error")
  logger.error("throwable", new Throwable("test"))
  logger.warn("warn")
  logger.info("info")
  logger.debug("debug")
}
