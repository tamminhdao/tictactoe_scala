package com.tamminhdao.ttt

class AIPlayer() extends Player {

  override def obtainCellSelection(board: Vector[Symbol]): Int = {
    board.indexOf(Board.emptyCell)
  }
}
