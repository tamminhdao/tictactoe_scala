package com.tamminhdao.ttt.Players
import com.tamminhdao.ttt.{Board, InOut}

class EasyAI extends Player {
  override def obtainCellSelection(board: Vector[Symbol],
                                   IO: InOut,
                                   selfSymbol: Symbol): Int = {
    board.indexOf(Board.emptyCell)
  }
}
