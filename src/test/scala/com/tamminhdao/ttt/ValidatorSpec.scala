package com.tamminhdao.ttt
import org.scalatest.FunSpec

class ValidatorSpec extends FunSpec {
  describe("The user input validator") {
    it("returns True when the cell selection is within the board limit") {
      val board = Board.newBoard(3)
      assert(Validator.validate(board, "0"))
      assert(Validator.validate(board, "8"))
    }

    it("returns False when the cell selection is out of the board limit") {
      val board = Board.newBoard(3)
      assert(!Validator.validate(board, "-1"))
      assert(!Validator.validate(board, "10"))
    }

    it("returns False when the cell selection is not an integer") {
      val board = Board.newBoard(3)
      assert(!Validator.validate(board, "abcd"))
      assert(!Validator.validate(board, "!@#$"))
    }

    it("returns False when the cell selected is not an empty cell") {
      val board = Board.newBoard(3)
      val updatedBoard = Board.insertSymbol(board, 5, 'X)
      assert(!Validator.validate(updatedBoard, "5"))
    }
  }
}
