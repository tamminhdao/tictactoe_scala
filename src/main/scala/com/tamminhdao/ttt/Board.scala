package com.tamminhdao.ttt

object Board {
  val emptyCell = '_

  def newBoard(size: Int): Vector[Symbol] = Vector.fill(size*size)(emptyCell)

  def dimension(board: Vector[Symbol]): Int = {
    Math.sqrt(board.length).toInt
  }

  def insertSymbol(board: Vector[Symbol], index: Int, symbol: Symbol): Vector[Symbol] = {
    board.updated(index, symbol)
  }

  def cellValue(board: Vector[Symbol], index: Int): Symbol = {
    board(index)
  }

  def cellIsEmpty(board: Vector[Symbol], index: Int): Boolean = {
    board(index) == emptyCell
  }

  def isFull(board: Vector[Symbol]): Boolean = {
    !board.contains(emptyCell)
  }

  def isEmpty(board: Vector[Symbol]): Boolean = {
    board == newBoard(dimension(board))
  }

  def availableCells(board: Vector[Symbol]): Vector[Int] = {
    board.zipWithIndex.collect {
      case(cell, index) if cell == emptyCell => index
    }
  }

  def winner(board: Vector[Symbol]): Symbol = {
    if (Rule.hasWinner(board)) {
      val threeInARow = Rule.winningCombos(board).filter(combo => Rule.identicalPlayerSymbol(combo))
      val winner = threeInARow.head
      winner.head
    } else if (Rule.isATie(board)) {
      'DoesNotExist
    } else {
      'TBD
    }
  }

  def rows(board: Vector[Symbol]): Vector[Vector[Symbol]] = {
    val boardSize = dimension(board)
    board.sliding(boardSize, boardSize).toVector
  }

  def columns(board: Vector[Symbol]): Vector[Vector[Symbol]] = {
    rows(board).transpose
  }

  def diagonals(board: Vector[Symbol]): Vector[Vector[Symbol]] = {
    Vector(topLeftToBottomRightDiagonal(board), topRightToBottomLeftDiagonal(board))
  }

  private def topLeftToBottomRightDiagonal(board: Vector[Symbol]): Vector[Symbol] = {
    val boardSize = dimension(board)
    val step = boardSize + 1
    val indexes = Vector.range(0, boardSize, 1).map(x => x * step)
    indexes.map(index => cellValue(board, index))
  }

  private def topRightToBottomLeftDiagonal(board: Vector[Symbol]): Vector[Symbol] = {
    val boardSize = dimension(board)
    val step = boardSize - 1
    val rangeEnd = boardSize + 1
    val indexes = Vector.range(1, rangeEnd, 1).map(x => x * step)
    indexes.map(index => cellValue(board, index))
  }
}
