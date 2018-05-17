package com.tamminhdao.ttt

class AIPlayer() extends Player {

  override def obtainCellSelection(board: Vector[Symbol],
                                   IO: InOut,
                                   selfSymbol: Symbol): Int = {
    val boardState = Board.isEmpty(board)
    boardState match {
      case true => 0
      case false => tryEveryMove(board, selfSymbol).sorted.reverse.head._2
    }
  }

  private def tryEveryMove(board: Vector[Symbol],
                           symbol: Symbol): Vector[(Int, Int)] = {
    val listOfCells = Board.availableCells(board)
    listOfCells.map(cell => (minimax(Board.insertSymbol(board, cell, symbol), symbol, 0, false), cell))
  }

  private def minimax(board: Vector[Symbol],
                      symbol: Symbol,
                      depth: Int,
                      maximizingPlayersTurn: Boolean): Int = {
    val winner = Board.winner(board)
    val opponent = otherPlayer(symbol)
    winner match {
      case `symbol` => 10 - depth
      case `opponent` => -10 + depth
      case 'DoesNotExist => 0
      case 'TBD => keepPlaying(board, symbol, depth, maximizingPlayersTurn)
    }
  }

  private def keepPlaying(board: Vector[Symbol],
                          symbol: Symbol,
                          depth: Int, 
                          maximizingPlayersTurn: Boolean): Int = {

    val marker = if (maximizingPlayersTurn) symbol else otherPlayer(symbol)
    val listOfCells = Board.availableCells(board)
    val scores = listOfCells.map(cell => minimax(Board.insertSymbol(board, cell, marker), symbol, depth + 1, !maximizingPlayersTurn))
    val bestScore = if (maximizingPlayersTurn) scores.max else scores.min
    bestScore
  }

  private def otherPlayer(symbol: Symbol): Symbol = {
    symbol match {
      case 'X => 'O
      case 'O => 'X
    }
  }
}
