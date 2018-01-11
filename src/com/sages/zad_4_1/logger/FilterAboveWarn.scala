package com.sages.zad_4_1.logger

trait FilterAboveWarn extends Appender {
  abstract override def append(message: String, level: Int): Unit =
    if (level <= Level.warn)
      super.append(message, level)
}
