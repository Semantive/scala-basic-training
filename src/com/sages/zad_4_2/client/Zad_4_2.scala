package com.sages.zad_4_2.client

import com.sages.zad_4_2.logger.{ConsoleAppender, FilterAboveWarn, LoggingSystem, Logger => MyLogger}

object Zad_4_2 extends App {
  import com.sages.zad_4_2.logger.Level._

  val logger = MyLogger(Zad_4_2.getClass)

  logger.log("info", info)
  logger.log("warn", warn)

  LoggingSystem.appender = new ConsoleAppender with FilterAboveWarn

  logger.log("info", info)
  logger.log("warn", warn)
}
