package com.tamminhdao.ttt

class EasyAI extends Player {
  override def obtainCellSelection(board: Vector[Symbol],
                                   IO: InOut,
                                   selfSymbol: Symbol): Int = {
    board.indexOf(Board.emptyCell)
  }
}
