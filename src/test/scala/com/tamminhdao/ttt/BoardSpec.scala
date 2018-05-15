package com.tamminhdao.ttt
import org.scalatest.FunSpec

class BoardSpec extends FunSpec {
 describe("The board") {
   val newBoard = Board.newBoard(3)

   it("can create an empty board") {
     val emptyBoard = Vector(
       '_, '_, '_,
       '_, '_, '_,
       '_, '_, '_
     )
     assert(Board.newBoard(3) == emptyBoard)
   }

   it("can return the correct board dimension") {
     assert(Board.dimension(newBoard) == 3)
   }

   it("can insert a player's symbol on a board") {
     val board = Board.insertSymbol(newBoard, 0, 'X)
     val expected_board = Vector(
       'X, '_, '_,
       '_, '_, '_,
       '_, '_, '_
     )
     assert(board == expected_board)
   }

   it("can insert different symbols of different players on a board") {
     val boardOne = Board.insertSymbol(newBoard, 0, 'X)
     val boardTwo = Board.insertSymbol(boardOne, 1, 'O)
     val expected_board = Vector(
       'X, 'O, '_,
       '_, '_, '_,
       '_, '_, '_
     )
     assert(boardTwo == expected_board)
   }

   it("can return the correct symbol at a particular cell") {
     val board = Board.insertSymbol(newBoard, 2, 'X)
     val cellOne = Board.cellValue(board, 1)
     val cellTwo = Board.cellValue(board, 2)
     assert(cellOne == '_)
     assert(cellTwo == 'X)
   }

   it("can distinguish between empty and non-empty cells") {
     val board = Board.insertSymbol(newBoard, 3, 'O)
     assert(Board.cellIsEmpty(board, 0))
     assert(!Board.cellIsEmpty(board, 3))
   }

   it("knows when a board is full") {
     val fullBoard = Vector(
       'X, 'O, 'X,
       'X, 'O, 'O,
       'X, 'X, 'O
     )
     assert(Board.isFull(fullBoard))
   }

   it("knows when a board is not full") {
     val board = Vector(
       'X, 'O, '_,
       'X, 'O, 'O,
       'X, 'X, 'O
     )
     assert(!Board.isFull(board))
   }

   it("knows when a board is empty") {
     val emptyBoard = Vector(
       '_, '_, '_,
       '_, '_, '_,
       '_, '_, '_
     )
     assert(Board.isEmpty(emptyBoard))
   }

   it("knows when a board is not empty") {
     val board = Vector(
       '_, '_, 'O,
       '_, '_, '_,
       '_, '_, '_
     )
     assert(!Board.isEmpty(board))
   }

   it("can return a list of all the empty cells") {
     val board = Vector(
       'X, '_, 'O,
       '_, 'X, '_,
       'O, '_, 'X
     )
     val emptyCells = Vector(1,3,5,7)
     assert(Board.availableCells(board) == emptyCells)
   }

   it("returns all the rows") {
     val board = Vector(
       'X, 'O, '_,
       'X, '_, 'O,
       '_, 'X, 'O
     )
     val rows = Vector(Vector('X, 'O, '_), Vector('X, '_, 'O), Vector('_, 'X, 'O))
     assert(rows === Board.rows(board))
   }

   it("returns all the columns") {
     val board = Vector(
       'X, 'O, '_,
       'X, '_, 'O,
       '_, 'X, 'O
     )
     val columns = Vector(Vector('X, 'X, '_), Vector('O, '_, 'X), Vector('_, 'O, 'O))
     assert(columns === Board.columns(board))
   }

   it("returns all the diagonals") {
      val board = Vector(
        'X, '_, 'O,
        '_, 'X, '_,
        'O, '_, 'X
      )
     val diagonals = Vector(Vector('X, 'X, 'X), Vector('O, 'X, 'O))
     assert(diagonals == Board.diagonals(board))
   }

   it("returns the correct winner symbol") {
     val board = Vector(
       'X, '_, 'O,
       '_, 'O, '_,
       'O, '_, 'X
     )
     val winner = Board.winner(board)
     assert(winner == 'O)
   }
 }
}
