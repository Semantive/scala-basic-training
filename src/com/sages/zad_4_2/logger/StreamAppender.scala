package com.sages.zad_4_2.logger

import java.io.{OutputStream, OutputStreamWriter}

class StreamAppender(stream: OutputStream) extends Appender {
  private[this] val rawWriter = new OutputStreamWriter(stream)

  private[logger] override def append(message: String, level: Int): Unit = {
    rawWriter.write(Level.stringify(level) + ": " + message)
    rawWriter.write("\n")
    rawWriter.flush()
  }
}
