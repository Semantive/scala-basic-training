package com.sages.zad_2_7

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

class Logger(val name: String) {
  def this(clazz: Class[_]) =
    this(clazz.getSimpleName)

  def log(message: String, level: Int = Level.info): Unit = {
    LoggingSystem.log("[" + name + "] " + message, level)
  }
}

trait LoggerSupport {
  this: Logger =>

  def debug(message: String): Unit = {
    log(message, Level.debug)
  }

  def info(message: String): Unit = {
    log(message, Level.info)
  }

  def warn(message: String): Unit = {
    log(message, Level.warn)
  }

  def error(message: String): Unit = {
    log(message, Level.error)
  }

  def error(message: String, throwable: Throwable): Unit = {
    log(message + "; " + throwable.getLocalizedMessage, Level.error)
  }
}

object LoggingSystem {
  private var _appender: Appender = new ConsoleAppender

  def appender: Appender = _appender
  def appender_=(newValue: Appender): Unit = _appender = newValue

  def log(message: String, level: Int): Unit = {
    _appender.append(message, level)
  }
}

object Zad_2_7 extends App {
  val logger = new Logger(Zad_2_7.getClass) with LoggerSupport

  logger.info("info")
  logger.warn("warn")

  LoggingSystem.appender = new ConsoleAppender with FilterAboveWarn

  logger.info("info")
  logger.warn("warn")
}
