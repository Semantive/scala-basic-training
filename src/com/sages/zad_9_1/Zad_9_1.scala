package com.sages.zad_9_1

import com.sages.zad_9_1.Level.LogLevel

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class AsyncLogger(maxLogLevel: LogLevel) {
  def log(message: String, level: LogLevel): Future[Option[String]] = Future {
    if (level.level > maxLogLevel.level)
      None
    else {
      println(message)
      Some(message)
    }
  }
}

object Level {
  sealed trait LogLevel {
    def level: Int
  }

  case object Error extends LogLevel {
    override def level: Int = 1
  }

  case object Warning extends LogLevel {
    override def level: Int = 2
  }

  case object Info extends LogLevel {
    override def level: Int = 3
  }

  case object Debug extends LogLevel {
    override def level: Int = 4
  }
}


object Zad_9_1 extends App {
  val logger = new AsyncLogger(Level.Warning)

  for (i <- 1 to 100) {
    Future {
      logger.log("I: " + i.toString, Level.Info).map { result =>
        println("result for info: " + result)
      }
      logger.log("D: " + i.toString, Level.Debug)
      logger.log("E: " + i.toString, Level.Error).map { result =>
        println("result for error: " + result)
      }
      logger.log("W: " + i.toString, Level.Warning)
    }
  }

  Thread.sleep(5000)
}
