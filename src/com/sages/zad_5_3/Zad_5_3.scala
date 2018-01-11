package com.sages.zad_5_3

object Zad_5_3 {
  val warmupCount = 100
  val measureCount = 20

  def measureTimeFunction(name: String)(operation: () => Any): Unit = {
    // warmup JIT
    for (_ <- 1 to warmupCount)
      operation()

    val start = System.currentTimeMillis()
    for (_ <- 1 to measureCount)
      operation()
    val end = System.currentTimeMillis()
    printf(s"elapsed time: %d ms - $name\n", (end - start) / measureCount)
  }

  def measureTime(name: String)(operation: => Any): Unit = {
    // warmup JIT
    for (_ <- 1 to warmupCount)
      operation

    val start = System.currentTimeMillis()
    for (_ <- 1 to measureCount)
      operation
    val end = System.currentTimeMillis()
    printf(s"elapsed time: %d ms - $name\n", (end - start) / measureCount)
  }

  val max = 100000000

  def whileLoop(): Int = {
    var sum = 0
    var i = 0
    while (i <= max) {
      sum += i
      i += 1
    }
    sum
  }

  def forLoop(): Int = {
    var sum = 0
    for (i <- 1 to max) {
      sum += i
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    def whileLoopLocal(): Int = {
      var sum = 0
      var i = 0
      while (i <= max) {
        sum += i
        i += 1
      }
      sum
    }

    def forLoopLocal(): Int = {
      var sum = 0
      for (i <- 1 to max) {
        sum += i
      }
      sum
    }

    measureTimeFunction("whileLoop")(whileLoop)
    measureTimeFunction("whileLoopLocal")(whileLoopLocal)
    measureTimeFunction("forLoop")(forLoop)
    measureTimeFunction("forLoopLocal")(forLoopLocal)

    measureTime("whileLoop()")(whileLoop())
    measureTime("whileLoopLocal()")(whileLoopLocal())
    measureTime("forLoop()")(forLoop())
    measureTime("forLoopLocal()")(forLoopLocal())
  }
}
