package com.sages.zad_6_6.logger

object LoggingSystem {
  private var _appender: Appender = new ConsoleAppender

  def appender: Appender = _appender
  def appender_=(newValue: Appender): Unit = _appender = newValue

  def log(message: String, level: Level): Unit = {
    _appender.append(message, level)
  }
}
