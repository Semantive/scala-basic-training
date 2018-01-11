package com.sages.zad_4_1.logger

class Logger(val name: String) {
  def this(clazz: Class[_]) =
    this(clazz.getSimpleName)

  def log(message: String, level: Int = Level.info): Unit = {
    LoggingSystem.log("[" + name + "] " + message, level)
  }
}
