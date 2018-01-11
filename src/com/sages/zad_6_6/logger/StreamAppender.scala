package com.sages.zad_6_6.logger

import java.io.{IOException, OutputStream, OutputStreamWriter}

class StreamAppender(stream: OutputStream) extends Appender {
  private[this] val rawWriter = new OutputStreamWriter(stream)

  private[logger] override def append(message: String, level: Level): Unit = {
    try {
      rawWriter.write(Level.stringify(level) + ": " + message)
      rawWriter.write("\n")
      rawWriter.flush()
    } catch {
      case e: IOException =>
        Console.err.println(e.getLocalizedMessage)
    }
  }
}
