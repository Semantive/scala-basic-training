package com.sages.zad_4_2.logger

trait FilterAboveWarn extends Appender {
  private[logger] abstract override def append(message: String, level: Int): Unit =
    if (level <= Level.warn)
      super.append(message, level)
}
