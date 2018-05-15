package com.tamminhdao.ttt
import org.scalatest.FunSpec

class RuleSpec extends FunSpec {
  describe("The rule") {
    it("can produce all the winning combos for a given board") {
      val board = Vector(
        'a, 'b, 'c,
        'd, 'e, 'f,
        'g, 'h, 'i
      )
      val expectedCombos = Vector(
        Vector('a, 'b, 'c), Vector('d, 'e, 'f), Vector('g, 'h, 'i),
        Vector('a, 'd, 'g), Vector('b, 'e, 'h), Vector('c, 'f, 'i),
        Vector('a, 'e, 'i), Vector('c, 'e, 'g)
      )
      assert(Rule.winningCombos(board) == expectedCombos)
    }

    it("has no winner and not a tie if the board is completely empty") {
      val emptyBoard = Board.newBoard(3)
      assert(!Rule.hasWinner(emptyBoard))
      assert(!Rule.isATie(emptyBoard))
      assert(Rule.gameInProgress(emptyBoard))
    }

    it("has no winner and not a tie while game is still in progress") {
      val board = Vector(
        'X, 'O, 'X,
        '_, '_, '_,
        'O, '_, 'X
      )
      assert(!Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(Rule.gameInProgress(board))
    }

    it("::hasWinner:: returns false if the game ends in a tie") {
      val board = Vector(
        'X, 'O, 'X,
        'X, 'O, 'O,
        'O, 'X, 'X
      )
      assert(!Rule.hasWinner(board))
      assert(Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if the top row is identical") {
      val board = Vector(
      'X, 'X, 'X,
      '_, 'O, '_,
      'O, '_, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if the middle row is identical") {
      val board = Vector(
        'X, 'O, 'X,
        'O, 'O, 'O,
        'O, '_, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if the bottom row is identical") {
      val board = Vector(
        'X, 'O, 'X,
        'O, '_, 'O,
        'X, 'X, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if the left column is identical") {
      val board = Vector(
        'X, 'O, 'O,
        'X, '_, 'O,
        'X, 'O, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if the middle column is identical") {
      val board = Vector(
        'X, 'O, 'X,
        '_, 'O, 'O,
        'X, 'O, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if the right column is identical") {
      val board = Vector(
        'X, 'O, 'O,
        '_, '_, 'O,
        'X, 'O, 'O
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if top left to bottom right diagonal is identical") {
      val board = Vector(
        'X, '_, 'O,
        '_, 'X, '_,
        'O, '_, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("has a win and is not a tie if top right to bottom left diagonal is identical") {
      val board = Vector(
        'X, '_, 'O,
        '_, 'O, '_,
        'O, '_, 'X
      )
      assert(Rule.hasWinner(board))
      assert(!Rule.isATie(board))
      assert(!Rule.gameInProgress(board))
    }

    it("::identicalPlayerSymbol:: returns True if three items in the collection are identical") {
      val triplet = Vector('X, 'X, 'X)
      assert(Rule.identicalPlayerSymbol(triplet))
    }

    it("::identicalPlayerSymbol:: returns False if three items in the collection are all empty cells") {
      val triplet = Vector('_, '_, '_)
      assert(!Rule.identicalPlayerSymbol(triplet))
    }
  }
}
