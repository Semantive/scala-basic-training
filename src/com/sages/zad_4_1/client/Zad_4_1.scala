package com.sages.zad_4_1.client

import com.sages.zad_4_1.logger.{ConsoleAppender, FilterAboveWarn, LoggerSupport, LoggingSystem, Logger => MyLogger}

object Zad_4_1 extends App {
  import com.sages.zad_4_1.logger.Level._

  val logger = new MyLogger(Zad_4_1.getClass) with LoggerSupport

  logger.log("info", info)
  logger.log("warn", warn)

  LoggingSystem.appender = new ConsoleAppender with FilterAboveWarn

  logger.log("info", info)
  logger.log("warn", warn)
}
