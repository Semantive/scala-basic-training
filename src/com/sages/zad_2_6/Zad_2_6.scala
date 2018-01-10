package com.sages.zad_2_6

import java.io.{FileOutputStream, OutputStream, OutputStreamWriter}

trait Appender {
  def append(message: String, level: Int): Unit
}

class StreamAppender(stream: OutputStream) extends Appender {
  private[this] val rawWriter = new OutputStreamWriter(stream)

  override def append(message: String, level: Int): Unit = {
    rawWriter.write(Level.stringify(level) + ": " + message)
    rawWriter.write("\n")
    rawWriter.flush()
  }
}

class ConsoleAppender extends StreamAppender(Console.out)

class FileAppender(path: String) extends StreamAppender(new FileOutputStream(path))

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

trait FilterAboveWarn extends Appender {
  abstract override def append(message: String, level: Int): Unit =
    if (level <= Level.warn)
      super.append(message, level)
}

object Zad_2_6 extends App {
  val appender = new ConsoleAppender with FilterAboveWarn

  appender.append("warn", Level.warn)
  appender.append("error", Level.error)
  appender.append("info", Level.info)
}
