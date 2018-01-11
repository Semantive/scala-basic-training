package com.sages.zad_6_6.logger

import java.io.{FileNotFoundException, FileOutputStream}

class FileAppender private(path: String) extends StreamAppender(new FileOutputStream(path))

object FileAppender {
  def apply(path: String): FileAppender =
    try new FileAppender(path)
    catch {
      case e: FileNotFoundException =>
        Console.err.println(e.getLocalizedMessage)
        throw e
    }
}