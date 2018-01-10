object Zad_1_3 extends App {
  for (i <- 1 to 100) {
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
