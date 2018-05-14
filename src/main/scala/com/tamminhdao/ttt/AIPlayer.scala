package com.tamminhdao.ttt

class AIPlayer() extends Player {

  def obtainCellSelection(board: Vector[Symbol]): Int = {
    board.indexOf(Board.emptyCell)
  }
}
