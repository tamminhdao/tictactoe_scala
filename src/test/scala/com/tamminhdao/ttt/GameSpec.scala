package com.tamminhdao.ttt
import com.tamminhdao.ttt.Players.{EasyAI, OpportunisticAI, UnbeatableAI}
import org.scalatest.FunSpec

class GameSpec extends FunSpec {
  describe("The game") {
    it("between 2 easy AIs: end in a win for the first player") {
      val ttt = new Game()
      val emptyBoard = Board.newBoard(3)
      val player1 = new EasyAI()
      val player2 = new EasyAI()
      val players = List(player1, player2)
      val symbols = List('X, 'O)
      val finalBoard = ttt.play(emptyBoard, players, symbols, MockIO)
      val expectedBoard = Vector(
        'X, 'O, 'X,
        'O, 'X, 'O,
        'X, '_, '_
      )
      assert(finalBoard == expectedBoard)
      assert(Rule.hasWinner(finalBoard))
      assert(Board.winner(finalBoard) == 'X)
    }

    it("between 2 unbeatable AIs: end in a tie") {
      val ttt = new Game()
      val emptyBoard = Board.newBoard(3)
      val player1 = new UnbeatableAI()
      val player2 = new UnbeatableAI()
      val players = List(player1, player2)
      val symbols = List('X, 'O)
      val finalBoard = ttt.play(emptyBoard, players, symbols, MockIO)
      assert(Rule.isATie(finalBoard))
    }

    it("between an unbeatable AI and an easy AI: end in a win for the unbeatable AI") {
      val ttt = new Game()
      val emptyBoard = Board.newBoard(3)
      val player1 = new UnbeatableAI()
      val player2 = new EasyAI()
      val players = List(player1, player2)
      val symbols = List('O, 'X)
      val finalBoard = ttt.play(emptyBoard, players, symbols, MockIO)
      val expectedBoard = Vector(
        'O, 'X, 'X,
        'O, '_, '_,
        'O, '_, '_
      )
      assert(finalBoard == expectedBoard)
      assert(Rule.hasWinner(finalBoard))
      assert(Board.winner(finalBoard) == 'O)
    }


    it("between an easy AI and an unbeatable AI: end in a win for the unbeatable AI") {
      val ttt = new Game()
      val emptyBoard = Board.newBoard(3)
      val player1 = new EasyAI()
      val player2 = new UnbeatableAI()
      val players = List(player1, player2)
      val symbols = List('O, 'X)
      val finalBoard = ttt.play(emptyBoard, players, symbols, MockIO)
      val expectedBoard = Vector(
      'O, 'O, 'X,
      'O, 'X, '_,
      'X, '_, '_
      )
      assert(finalBoard == expectedBoard)
      assert(Rule.hasWinner(finalBoard))
      assert(Board.winner(finalBoard) == 'X)
    }

    it("the unbeatable AI never loses to the opportunistic AI - unbeatable AI goes first") {
      var unbeatableAiNeverLoses = true
      for (_ <- 1 to 50) {
        val ttt = new Game()
        val emptyBoard = Board.newBoard(3)
        val player1 = new UnbeatableAI()
        val player2 = new OpportunisticAI()
        val players = List(player1, player2)
        val symbols = List('O, 'X)
        val finalBoard = ttt.play(emptyBoard, players, symbols, MockIO)
        if (Board.winner(finalBoard) == 'X) {
          unbeatableAiNeverLoses = false
        }
      }
      assert(unbeatableAiNeverLoses)
    }

    it("the unbeatable AI never loses to the opportunistic AI - opportunistic AI goes first") {
      var unbeatableAiNeverLoses = true
      for (_ <- 1 to 50) {
        val ttt = new Game()
        val emptyBoard = Board.newBoard(3)
        val player1 = new OpportunisticAI()
        val player2 = new UnbeatableAI()
        val players = List(player1, player2)
        val symbols = List('O, 'X)
        val finalBoard = ttt.play(emptyBoard, players, symbols, MockIO)
        if (Board.winner(finalBoard) == 'O) {
          unbeatableAiNeverLoses = false
        }
      }
      assert(unbeatableAiNeverLoses)
    }
  }
}
