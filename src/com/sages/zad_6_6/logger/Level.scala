package com.sages.zad_6_6.logger

sealed trait Level
case object Error extends Level
case object Warn extends Level
case object Info extends Level
case object Debug extends Level

object Level {
  def stringify(level: Level): String =
    if (level == Info) "INFO "
    else if (level == Error) "ERROR"
    else if (level == Warn) "WARN "
    else if (level == Debug) "DEBUG"
    else "N/A"
}
