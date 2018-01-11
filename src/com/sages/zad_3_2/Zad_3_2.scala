package com.sages.zad_3_2

import scala.language.dynamics

class Logger extends Dynamic {
  def applyDynamic(name: String)(args: Any*): Unit = {
    println(name + "(" + args.mkString(", ") + ")")
  }

  def applyDynamicNamed(name: String)(args: (String, Any)*): Unit = {
    println(name + "(" + args.map(p => p._1 + "=" + p._2).mkString(", ") + ")")
  }
}

object Zad_3_2 extends App {
  val logger = new Logger

  logger.example(1, 2 ,3)
  logger.exampleNamed(a = 1, b = 2)
}
