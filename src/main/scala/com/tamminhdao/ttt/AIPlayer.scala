package com.tamminhdao.ttt

class AIPlayer() extends Player {

  override def obtainCellSelection(board: Vector[Symbol], IO: InOut): Int = {
    val boardState = Board.isEmpty(board)
    boardState match {
      case true => 0
      case false => tryEveryMove(board, 'X).sorted.reverse.head._2
    }
  }

  private def tryEveryMove(board: Vector[Symbol],
                   symbol: Symbol): Vector[(Int, Int)] = {
    val listOfCells = Board.availableCells(board)
    listOfCells.map(cell => (minimax(Board.insertSymbol(board, cell, symbol), 0, false), cell))
  }

  private def minimax(board: Vector[Symbol],
              depth: Int,
              maximizingPlayersTurn: Boolean): Int = {
    val winner = Board.winner(board)
    winner match {
      case 'X => 10 - depth
      case 'O => -10 + depth
      case 'DoesNotExist => 0
      case 'TBD => keepPlaying(board, depth, maximizingPlayersTurn)
    }
  }

  private def keepPlaying(board: Vector[Symbol], 
                          depth: Int, 
                          maximizingPlayersTurn: Boolean): Int = {
    val symbol = if (maximizingPlayersTurn) 'X else 'O
    val listOfCells = Board.availableCells(board)
    val scores = listOfCells.map(cell => minimax(Board.insertSymbol(board, cell, symbol), depth + 1, !maximizingPlayersTurn))
    val bestScore = if (maximizingPlayersTurn) scores.max else scores.min
    bestScore
  }
}
