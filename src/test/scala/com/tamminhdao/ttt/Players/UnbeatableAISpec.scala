package com.tamminhdao.ttt.Players
import com.tamminhdao.ttt.IO
import org.scalatest.FunSpec

class UnbeatableAISpec extends FunSpec {
  describe("The unbeatable computer player") {
    it("blocks an opponent's win - as player X") {
      val board = Vector(
        'O, 'O, 'X,
        '_, 'X, '_,
        'O, '_, '_
      )
      val playerX = new UnbeatableAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 3)
    }

    it("blocks an opponent's win - as player O") {
      val board = Vector(
        'O, 'O, 'X,
        'X, 'X, '_,
        'O, '_, '_
      )
      val playerO = new UnbeatableAI()
      assert(playerO.obtainCellSelection(board, IO, 'O) == 5)
    }

    it("takes an immediate win over creating a fork - as player X") {
      val board = Vector(
        'O, 'O, 'X,
        '_, 'X, '_,
        '_, 'O, '_
      )
      val playerX = new UnbeatableAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 6)
    }

    it("takes an immediate win over creating a fork - as player O") {
      val board = Vector(
        'O, 'X, 'X,
        '_, 'O, '_,
        '_, 'X, '_
      )
      val playerO = new UnbeatableAI()
      assert(playerO.obtainCellSelection(board, IO, 'O) == 8)
    }

    it("takes an immediate win over an eventual tie - as player X") {
      val board = Vector(
        '_, '_, 'O,
        '_, 'X, 'X,
        '_, 'O, 'O
      )
      val playerX = new UnbeatableAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 3)
    }

    it("takes an immediate win over an eventual tie - as player O") {
      val board = Vector(
        'X, '_, '_,
        'O, 'O, '_,
        'X, 'X, '_
      )
      val playerO = new UnbeatableAI()
      assert(playerO.obtainCellSelection(board, IO, 'O) == 5)
    }

    it("takes a win over blocking an opponent - as player X") {
      val board = Vector(
        'O, 'O, 'X,
        '_, '_, 'X,
        'O, '_, '_
      )
      val playerX = new UnbeatableAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 8)
    }

    it("takes a win over blocking an opponent - as player O") {
      val board = Vector(
        'X, '_, 'X,
        '_, '_, 'X,
        '_, 'O, 'O
      )
      val playerO = new UnbeatableAI()
      assert(playerO.obtainCellSelection(board, IO, 'O) == 6)
    }


    it("takes the center cell to prevent a potential fork") {
      val board = Vector(
        'O, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val playerX = new UnbeatableAI()
      assert(playerX.obtainCellSelection(board, IO, 'X) == 4)
    }

    it("takes the first cell if the board is empty") {
      val board = Vector(
        '_, '_, '_,
        '_, '_, '_,
        '_, '_, '_
      )
      val playerO = new UnbeatableAI()
      assert(playerO.obtainCellSelection(board, IO, 'O) == 0)
    }
  }
}
