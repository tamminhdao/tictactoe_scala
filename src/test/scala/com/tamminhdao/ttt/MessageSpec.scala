package com.tamminhdao.ttt
import org.scalatest.FunSpec

class MessageSpec extends FunSpec {
  describe("The console messages") {
    it("replaces empty cells with their cell indexes") {
      val board = Vector(
        '_, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val formattedBoard = " 0   1   2 " + "\n" +
                           "---|---|---" + "\n" +
                           " 3   4   5 " + "\n" +
                           "---|---|---" + "\n" +
                           " 6   7   8 "
      assert(Message.formatBoard(board) == formattedBoard)
    }

    it("displays the correct symbol if a cell is occupied") {
      val board = Vector(
        'X, 'O, 'X,
        'X, 'O, 'O,
        'X, 'X, 'O
      )
      val formattedBoard = " X   O   X " + "\n" +
                           "---|---|---" + "\n" +
                           " X   O   O " + "\n" +
                           "---|---|---" + "\n" +
                           " X   X   O "
      assert(Message.formatBoard(board) == formattedBoard)
    }

    it("can display a board with some occupied cells and some empty cells") {
      val board = Vector(
        'O, '_, 'O,
        '_, '_, '_,
        '_, 'X, '_
      )
      val formattedBoard = " O   1   O " + "\n" +
                           "---|---|---" + "\n" +
                           " 3   4   5 " + "\n" +
                           "---|---|---" + "\n" +
                           " 6   X   8 "
      assert(Message.formatBoard(board) == formattedBoard)
    }
  }
}
