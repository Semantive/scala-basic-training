package com.sages.zad_6_1.logger

import java.io.{OutputStream, OutputStreamWriter}

class StreamAppender(stream: OutputStream) extends Appender {
  private[this] val rawWriter = new OutputStreamWriter(stream)

  private[logger] override def append(message: String, level: Level): Unit = {
    rawWriter.write(Level.stringify(level) + ": " + message)
    rawWriter.write("\n")
    rawWriter.flush()
  }
}
