import scala.io.StdIn

object Zad_1_4a extends App {
  val start = StdIn.readInt()
  val end = StdIn.readInt()

  for (i <- start to end) {
    val by3 = i % 3 == 0
    val by5 = i % 5 == 0

    if (by3 && by5) {
      println("FizzBuzz")
    } else if (by3) {
      println("Fizz")
    } else if (by5) {
      println("Buzz")
    } else {
      println(i)
    }
  }

}
