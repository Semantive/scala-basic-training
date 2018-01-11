package com.sages.zad_6_1.client

import com.sages.zad_6_1.logger._

object Zad_6_1 extends App {
  val logger = Logger(Zad_6_1.getClass)
  LoggingSystem.appender = new SmartAppender

  logger.log("info", Info)
  logger.log("warn", Warn)
  logger.log("error", Error)
}
