package com.tamminhdao.ttt

class Game {
  def play(board: Vector[Symbol],
           players: List[Player],
           symbols: List[Symbol]): Unit = {

    IO.publishOutput(Message.formatBoard(board))
    IO.publishNewLine()

    if (Rule.gameInProgress(board)) {
      val currentPlayer = players.head
      val currentPlayerSymbol = symbols.head
      val cellIndex = currentPlayer.obtainCellSelection(board, IO)
      val updatedBoard = Board.insertSymbol(board, cellIndex, currentPlayerSymbol)

      play(updatedBoard, players.reverse, symbols.reverse)
    } else {
       IO.publishOutput("Game Over")
    }
  }
}
