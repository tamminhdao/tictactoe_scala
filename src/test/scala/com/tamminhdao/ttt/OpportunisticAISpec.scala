package com.tamminhdao.ttt
import org.scalatest.FunSpec

class OpportunisticAISpec extends FunSpec {
  describe("The opportunistic computer player") {
    it("takes the first cell if the board is empty") {
      val board = Vector(
        '_, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val player = new OpportunisticAI()
      assert(player.obtainCellSelection(board, IO, 'O) == 0)
    }

    it("takes the first cell on the board if it sees no immediate win or lose") {
      val board = Vector(
        'X, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val player = new OpportunisticAI()
      assert(player.obtainCellSelection(board, IO, 'O) == 1)
    }

    it("takes a win - as player X") {
      val board = Vector(
        'O, 'O, 'X,
        '_, '_, '_,
        'X, '_, '_
      )
      val playerX = new OpportunisticAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 4)
    }

    it("blocks an opponent from winning - as player X") {
      val board = Vector(
        'O, 'O, 'X,
        '_, 'X, '_,
        'O, '_, '_
      )
      val playerX = new OpportunisticAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 3)
    }

    it("takes a win over blocking an opponent - as player O") {
      val board = Vector(
        'X, '_, 'X,
        '_, '_, 'X,
        '_, 'O, 'O
      )
      val player = new OpportunisticAI()
      assert(player.obtainCellSelection(board, IO, 'O) == 6)
    }
  }
}
