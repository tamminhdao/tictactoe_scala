package com.tamminhdao.ttt

class OpportunisticAI extends Player {
  override def obtainCellSelection(board: Vector[Symbol],
                                   IO: InOut,
                                   selfSymbol: Symbol): Int = {

    val scoreAndCell = tryEveryMove(board, selfSymbol)
    if (scoreAndCell.exists(pair => pair._1 == 10)) {
      scoreAndCell.max._2
    } else {
      scoreAndCell.min._2
    }
  }

  private def tryEveryMove(board: Vector[Symbol],
                           symbol: Symbol): Vector[(Int, Int)] = {
    val listOfCells = Board.availableCells(board)
    val scoresCellsAsSelf = listOfCells.map(cell => (scoreEveryCell(Board.insertSymbol(board, cell, symbol), symbol), cell))
    val scoresCellsAsOpponent = listOfCells.map(cell => (scoreEveryCell(Board.insertSymbol(board, cell, otherPlayer(symbol)), symbol), cell))
    scoresCellsAsSelf ++ scoresCellsAsOpponent
  }

  private def scoreEveryCell(board: Vector[Symbol],
                             symbol: Symbol): Int = {
    val winner = Board.winner(board)
    val opponent = otherPlayer(symbol)
    winner match {
      case `symbol` => 10
      case `opponent` => -10
      case _ => 0
    }
  }

  private def otherPlayer(symbol: Symbol): Symbol = {
    symbol match {
      case 'X => 'O
      case 'O => 'X
    }
  }
}
