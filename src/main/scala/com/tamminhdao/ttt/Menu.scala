package com.tamminhdao.ttt

object Menu {

  def initGame(): Unit = {
    IO.publishOutput(Message.welcome())
    val ttt = new Game()
    val emptyBoard = Board.newBoard(3)
    val players = setUpPlayers()
    val symbols = List('X, 'O)
    IO.publishOutput(Message.announceGameStart())
    ttt.play(emptyBoard, players, symbols, IO)
  }

  def setUpPlayers(): List[Player] = {
    val playerOne = Menu.selectPlayerType("one")
    val playerTwo = Menu.selectPlayerType("two")
    List(playerOne, playerTwo)
  }

  private def selectPlayerType(playerID: String): Player = {
    val player = IO.obtainInput(Message.selectPlayer(playerID))
    player match {
      case "1" => new HumanPlayer()
      case "2" => new EasyAI()
      case "3" => new AIPlayer()
      case _ =>
        IO.publishOutput(Message.invalidInput())
        selectPlayerType(playerID)
    }
  }
}
