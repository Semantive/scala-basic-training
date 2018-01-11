package com.sages.zad_4_2.logger

object Level {
  val error: Int = 1
  val warn: Int = 2
  val info: Int = 3
  val debug: Int = 4

  def stringify(level: Int): String =
    if (level == Level.info) "INFO "
    else if (level == Level.error) "ERROR"
    else if (level == Level.warn) "WARN "
    else if (level == Level.debug) "DEBUG"
    else "N/A"
}
