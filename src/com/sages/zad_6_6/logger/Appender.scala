package com.sages.zad_6_6.logger

trait Appender {
  private[logger] def append(message: String, level: Level): Unit
}


















