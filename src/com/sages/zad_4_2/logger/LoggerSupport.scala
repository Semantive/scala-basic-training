package com.sages.zad_4_2.logger

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
