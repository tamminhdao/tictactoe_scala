package com.tamminhdao.ttt

object MockIO extends InOut {
  def obtainInput(input: String): String = {
    "1"
  }

  def publishOutput(output: String): Unit = {
    obtainInput("1")
  }
}
