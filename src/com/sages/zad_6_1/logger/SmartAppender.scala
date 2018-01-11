package com.sages.zad_6_1.logger

class SmartAppender extends Appender {
  override private[logger] def append(message: String, level: Level): Unit = level match {
    case Error =>
      Console.err.println(Level.stringify(level) + ": " + message)

    case _ =>
      Console.out.println(Level.stringify(level) + ": " + message)
  }
}
