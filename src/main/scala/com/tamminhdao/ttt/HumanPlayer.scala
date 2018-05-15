package com.tamminhdao.ttt

class HumanPlayer extends Player {
  override def obtainCellSelection(board: Vector[Symbol]): Int = {
    val cell = IO.obtainInput("Enter your cell selection\n")
    val valid = Validator.validate(board, cell)
    valid match {
      case false => obtainCellSelection(board)
      case true => cell.toInt
    }
  }
}
