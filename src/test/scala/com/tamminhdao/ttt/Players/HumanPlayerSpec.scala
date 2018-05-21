package com.tamminhdao.ttt.Players
import com.tamminhdao.ttt.{Board, MockIO}
import org.scalatest.FunSpec

class HumanPlayerSpec extends FunSpec {
  describe("The human player") {
    it("can obtain a cell selection") {
      val board = Board.newBoard(3)
      val human = new HumanPlayer()
      val cell = human.obtainCellSelection(board, MockIO, 'O)
      assert(cell == 1)
    }
  }
}
