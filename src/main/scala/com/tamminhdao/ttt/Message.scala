package com.tamminhdao.ttt

object Message {
  def welcome(): String = {
    "**********************\n" +
      "Welcome to Tic-Tac-Toe\n" +
        "**********************\n"
  }

  def selectPlayer(playerID: String): String = {
    s"Setting up player $playerID\n\n" +
    "Select 1 for a human player\n" +
      "    or 2 for an easy computer player\n" +
       "    or 3 for an unbeatable computer player.\n"
  }

  def announceGameStart(): String = {
    "The game will start now.\n" +
    "Player one's symbol is X.\n" +
    "Player two's symbol is O.\n"
  }

  def formatBoard(board: Vector[Symbol]): String = {
    val cells = board.zipWithIndex.map(symbolIndexPair => matchCell(symbolIndexPair))
    val firstRow = s" ${cells(0)}   ${cells(1)}   ${cells(2)} "
    val secondRow = s" ${cells(3)}   ${cells(4)}   ${cells(5)} "
    val thirdRow = s" ${cells(6)}   ${cells(7)}   ${cells(8)} "
    val rowSeparator = separator(Board.dimension(board))
    firstRow + rowSeparator + secondRow + rowSeparator + thirdRow
  }

  private def separator(boardDimension: Int): String = {
    val pipe = "|"
    val dashes = "---"
    val separator = "\n" + Vector.fill(boardDimension)(dashes).mkString(pipe) + "\n"
    separator
  }

  private def matchCell(symbolAndIndex: (Symbol, Int)): Any = {
    symbolAndIndex._1 match {
      case '_ => symbolAndIndex._2
      case 'X => "X"
      case 'O => "O"
    }
  }

  def cellSelection(): String = {
    "Select an empty cell on the board:\n"
  }

  def invalidInput(): String = {
    "That is not a valid input. Try again!\n"
  }

  def announceTurn(symbol: Symbol): String = {
    s"It is $symbol's turn.\n"
  }

  def gameOver(): String = {
    "Game Over"
  }

  def gameEndStatus(board: Vector[Symbol]): String = {
    val winner = Board.winner(board)
    winner match {
      case 'X => "The winner is X!"
      case 'O => "The winner is O!"
      case 'DoesNotExist => "It's a tie."
    }
  }
}
