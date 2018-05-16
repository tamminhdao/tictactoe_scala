package com.tamminhdao.ttt

trait Player {
  def obtainCellSelection(board: Vector[Symbol], IO: InOut): Int
}
