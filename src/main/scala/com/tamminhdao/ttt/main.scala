package com.tamminhdao.ttt

object main {
  def main(args: Array[String]): Unit = {
    println("Hello TTT")
    val ttt = new Game()
    val emptyBoard = Board.newBoard(3)
    val player1 = new AIPlayer()
    val player2 = new HumanPlayer()
    val players = List(player1, player2)
    val symbols = List('X, 'O)
    ttt.play(emptyBoard, players, symbols)
  }
}
