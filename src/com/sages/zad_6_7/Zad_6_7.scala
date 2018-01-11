package com.sages.zad_6_7

class LogMatcher {
  private val logPattern = "(.*) __ (.*) __ (.*) __ (.*)".r

  def format(dateTime: String, level: String, name: String, message: String): String =
    s"$dateTime __ $level __ $name __ $message"

  def unapply(line: String): Option[(String, String, String, String)] = line match {
    case `logPattern`(dateTime, level, name, message) =>
      Some((dateTime, level, name, message))

    case _ =>
      None
  }
}

object Zad_6_7 extends App {
  val logMatcher = new LogMatcher

  val (dateTime, level, name, message) = ("2018-01-01", "INFO", "App", "Test")
  logMatcher.format(dateTime, level, name, message) match {
    case `logMatcher`(newDateTime, newLevel, newName, newMessage) =>
      println((newDateTime, newLevel, newName, newMessage))
  }
}
