package com.tamminhdao.ttt.Players
import com.tamminhdao.ttt.InOut

trait Player {
  def obtainCellSelection(board: Vector[Symbol], IO: InOut, selfSymbol: Symbol): Int
}
