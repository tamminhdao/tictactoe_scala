package com.tamminhdao.ttt.Players
import com.tamminhdao.ttt.IO
import org.scalatest.FunSpec

class EasyAISpec extends FunSpec {
 describe("The easy AI") {
   it("takes the first cell on am empty board") {
     val board = Vector(
       '_, '_, '_,
       '_, '_, '_,
       '_, '_, '_
     )
     val playerX = new EasyAI()
     assert(playerX.obtainCellSelection(board, IO, 'O) == 0)
   }

   it("takes the first cell (index 0) on the board if it's available") {
     val board = Vector(
       '_, 'O, '_,
       '_, 'X, '_,
       'X, '_, 'O
     )
     val playerX = new EasyAI()
     assert(playerX.obtainCellSelection(board, IO, 'X) == 0)
   }

   it("takes the second cell (index 1) on the board if it's available") {
     val board = Vector(
       'X, '_, '_,
       '_, '_, 'O,
       '_, 'O, 'X
     )
     val playerX = new EasyAI()
     assert(playerX.obtainCellSelection(board, IO, 'O) == 1)
   }

   it("takes the third cell (index 2) on the board if it's available") {
     val board = Vector(
       'X, 'O, '_,
       '_, '_, '_,
       '_, '_, '_
     )
     val playerX = new EasyAI()
     assert(playerX.obtainCellSelection(board, IO, 'X) == 2)
   }
 }
}
