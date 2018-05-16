package com.tamminhdao.ttt
import org.scalatest.FunSpec

class HumanPlayerSpec extends FunSpec {
  describe("The human player") {
    it("can obtain a cell selection") {
      val board = Board.newBoard(3)
      val human = new HumanPlayer()
      val cell = human.obtainCellSelection(board, MockIO)
      assert(cell == 1)
    }
  }
}
