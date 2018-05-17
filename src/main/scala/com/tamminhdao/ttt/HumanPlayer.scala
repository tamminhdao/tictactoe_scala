package com.tamminhdao.ttt

class HumanPlayer extends Player {
  override def obtainCellSelection(board: Vector[Symbol], IO: InOut, selfSymbol: Symbol): Int = {
    val cell = IO.obtainInput(Message.cellSelection())
    val valid = Validator.validate(board, cell)
    valid match {
      case false => obtainCellSelection(board, IO, selfSymbol)
      case true => cell.toInt
    }
  }
}
