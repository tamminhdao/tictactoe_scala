package com.tamminhdao.ttt

class HumanPlayer extends Player {
  override def obtainCellSelection(board: Vector[Symbol], IO: InOut): Int = {
    val cell = IO.obtainInput(Message.cellSelection())
    val valid = Validator.validate(board, cell)
    valid match {
      case false => obtainCellSelection(board, IO)
      case true => cell.toInt
    }
  }
}
