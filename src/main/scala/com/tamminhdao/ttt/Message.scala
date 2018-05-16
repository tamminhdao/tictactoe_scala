package com.tamminhdao.ttt

object Message {
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
}
