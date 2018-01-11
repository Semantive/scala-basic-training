package com.sages.zad_6_6.logger

class Logger private(val name: String) {
  private def this(clazz: Class[_]) =
    this(clazz.getSimpleName)

  def log(message: String, level: Level = Info): Unit = {
    LoggingSystem.log("[" + name + "] " + message, level)
  }
}

object Logger {
  def apply(name: String): Logger =
    new Logger(name)

  def apply(clazz: Class[_]): Logger =
    new Logger(clazz)
}
