package com.sages.zad_3_1

class Logger {
  def log(obj: {def description: String}): Unit = {
    println(obj.description)
  }
}

class WithDef {
  def description = "WithDef"
}

class WithVal {
  val description = "WithVal"
}

class WithLazyVal {
  lazy val description = "WithLazyVal"
}

class WithVar {
  var description = "WithVar"
}

object Zad_3_1 extends App {
  val logger = new Logger

  logger.log(new WithDef)
  logger.log(new WithVal)
  logger.log(new WithLazyVal)
  logger.log(new WithVar)
}
