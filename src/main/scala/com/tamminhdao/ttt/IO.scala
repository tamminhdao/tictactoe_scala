package com.tamminhdao.ttt
import scala.io.StdIn.readLine

object IO extends InOut {
  def obtainInput(input: String): String = {
    readLine(input).trim
  }

  def publishOutput(output: String): Unit = {
    println(output)
  }

  def publishNewLine(): Unit = {
    println("\n")
  }
}
