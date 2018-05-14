package com.tamminhdao.ttt

class Game {
  def play(board: Vector[Symbol],
           players: List[Player],
           symbols: List[Symbol]): Unit = {

    println(board)

    if (Rule.gameInProgress(board)) {
      val currentPlayer = players.head
      val currentPlayerSymbol = symbols.head
      val cellIndex = currentPlayer.obtainCellSelection(board)
      val updatedBoard = Board.insertSymbol(board, cellIndex, currentPlayerSymbol)

      play(updatedBoard, players.reverse, symbols.reverse)
    } else {
       println("Game Over")
    }
  }
}
