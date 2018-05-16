package com.tamminhdao.ttt

object Message {
  def welcome(): String = {
    "**********************\n" +
      "Welcome to Tic-Tac-Toe\n" +
        "**********************\n"
  }

  def selectGameType(): String = {
    "Select 1 for a human vs human game\n" +
      "Select 2 for a computer vs human game\n" +
        "Select 3 for a human vs computer game\n"
  }

  def humanVsHuman(): String = {
    "Starting a new Human versus Human game...\n"
  }

  def AIVsHuman(): String = {
    "Starting a new Computer versus Human game...\n"
  }

  def humanVsAI(): String = {
    "Starting a new Human versus Computer game...\n"
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
