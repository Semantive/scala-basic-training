package com.sages.zad_6_1.logger

trait LoggerSupport {
  this: Logger =>

  def debug(message: String): Unit = {
    log(message, Debug)
  }

  def info(message: String): Unit = {
    log(message, Info)
  }

  def warn(message: String): Unit = {
    log(message, Warn)
  }

  def error(message: String): Unit = {
    log(message, Error)
  }

  def error(message: String, throwable: Throwable): Unit = {
    log(message + "; " + throwable.getLocalizedMessage, Error)
  }
}
