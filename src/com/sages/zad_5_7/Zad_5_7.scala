package com.sages.zad_5_7

import java.io.File

object Zad_5_7 extends App {
  def listFiles(file: File): List[File] =
    if (file.isFile) file :: Nil
    else if (file.isDirectory)
      (for (f <- file.listFiles().toList)
        yield listFiles(f)).flatten
    else Nil

  def listFilesFlatMap(file: File): List[File] =
    if (file.isFile) file :: Nil
    else if (file.isDirectory)
      file.listFiles().toList.flatMap(listFilesFlatMap)
    else Nil

  println(listFiles(new File(".")).map(_.getPath).mkString("\n"))
  println(listFilesFlatMap(new File(".")).map(_.getPath).mkString("\n"))
}
