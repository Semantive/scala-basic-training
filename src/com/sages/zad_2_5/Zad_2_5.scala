package com.sages.zad_2_5

import java.io.{FileOutputStream, OutputStream, OutputStreamWriter}

trait Appender {
  def append(message: String): Unit
}

class StreamAppender(stream: OutputStream) extends Appender {
  private[this] val rawWriter = new OutputStreamWriter(stream)

  override def append(message: String): Unit = {
    rawWriter.write(message)
    rawWriter.write("\n")
    rawWriter.flush()
  }
}

object ConsoleAppender extends StreamAppender(Console.out)

class FileAppender(path: String) extends StreamAppender(new FileOutputStream(path))

object Zad_2_5 extends App {
  ConsoleAppender.append("test")
}
