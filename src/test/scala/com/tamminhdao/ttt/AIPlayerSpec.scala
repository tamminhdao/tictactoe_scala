package com.tamminhdao.ttt
import org.scalatest.FunSpec

class AIPlayerSpec extends FunSpec {
  describe("The unbeatable computer player") {
    it("blocks an opponent's win") {
      val board = Vector(
        'O, 'O, 'X,
        '_, 'X, '_,
        'O, '_, '_
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 3)
    }

    it("takes an immediate win over creating a fork") {
      val board = Vector(
        'O, 'O, 'X,
        '_, 'X, '_,
        '_, 'O, '_
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 6)
    }

    it("takes an immediate win over an eventual tie") {
      val board = Vector(
        '_, '_, 'O,
        '_, 'X, 'X,
        '_, 'O, 'O
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 3)
    }

    it("takes a win over blocking an opponent") {
      val board = Vector(
        'O, 'O, 'X,
        '_, '_, 'X,
        'O, '_, '_
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 8)
    }

    it("prevents opponent from creating a fork") {
      val board = Vector(
        '_, 'O, '_,
        'O, 'X, '_,
        '_, 'X, 'O
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 2)
    }

    it("takes the center cell to prevent a potential fork") {
      val board = Vector(
        'O, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 4)
    }

    it("takes the first cell if the board is empty") {
      val board = Vector(
        '_, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val playerX = new AIPlayer()
      assert(playerX.obtainCellSelection(board, IO) == 0)
    }
  }
}
