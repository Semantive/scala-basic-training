package com.sages.zad_4_2.logger

trait Appender {
  private[logger] def append(message: String, level: Int): Unit
}


















