package com.tamminhdao.ttt

object Rule {
  def winningCombos(board: Vector[Symbol]): Vector[Vector[Symbol]] = {
    val rows = Board.rows(board)
    val columns = Board.columns(board)
    val diagonals = Board.diagonals(board)
    rows ++ columns ++ diagonals
  }

  def gameInProgress(board: Vector[Symbol]): Boolean = {
    !isATie(board) && !hasWinner(board)
  }

  def isATie(board: Vector[Symbol]): Boolean = {
    Board.isFull(board) && !hasWinner(board)
  }

  def hasWinner(board: Vector[Symbol]): Boolean = {
    if (Board.isEmpty(board))
      false
    else
      winningCombos(board).exists(combo => identicalPlayerSymbol(combo))
  }

  def identicalPlayerSymbol(collective: Vector[Symbol]): Boolean = {
    val head = collective.head
    val identical = collective.forall(element => element == head)
    identical && head!= Board.emptyCell
  }
}
