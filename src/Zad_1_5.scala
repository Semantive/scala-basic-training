import java.io.{BufferedReader, FileInputStream, InputStreamReader}

object Zad_1_5 extends App {
  val path = args(0)

  val inputStream = new FileInputStream(path)
  val rawReader = new InputStreamReader(inputStream)
  val reader = new BufferedReader(rawReader)

  var linesTotal = 0
  var nonEmptyLines = 0
  var line = ""
  while ({ line = reader.readLine(); line != null}) {
    linesTotal += 1
    if (line != "") {
      nonEmptyLines += 1
    }
  }

  println("Total: " + linesTotal)
  println("Non empty: " + nonEmptyLines)

  reader.close()
  rawReader.close()
  inputStream.close()
}
