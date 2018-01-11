package com.sages.zad_6_1.logger

trait Appender {
  private[logger] def append(message: String, level: Level): Unit
}


















