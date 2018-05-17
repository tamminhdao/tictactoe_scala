package com.tamminhdao.ttt

class Game {
  def play(board: Vector[Symbol],
           players: List[Player],
           symbols: List[Symbol],
           IO: InOut): Vector[Symbol] = {

    IO.publishOutput(Message.formatBoard(board))
    IO.publishNewLine()

    if (Rule.gameInProgress(board)) {
      val currentPlayer = players.head
      val currentPlayerSymbol = symbols.head

      IO.publishOutput(Message.announceTurn(currentPlayerSymbol))

      val cellIndex = currentPlayer.obtainCellSelection(board, IO, currentPlayerSymbol)
      val updatedBoard = Board.insertSymbol(board, cellIndex, currentPlayerSymbol)

      play(updatedBoard, players.reverse, symbols.reverse, IO)
    } else {
       IO.publishOutput(Message.gameOver())
       IO.publishOutput(Message.gameEndStatus(board))
       board
    }
  }
}
