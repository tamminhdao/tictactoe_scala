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
    playAgain()
  }

  private def playAgain(): Unit = {
    val answer = IO.obtainInput(Message.playAgain())
    val affirmative = List("yes", "Yes", "y", "Y")
    val negative = List("no", "No", "n", "N")

    if (affirmative.contains(answer)) {
      Menu.initGame()
    } else if (negative.contains(answer)) {
      IO.publishOutput(Message.goodBye())
    } else {
      IO.publishOutput(Message.invalidInput())
      playAgain()
    }
  }

  private def setUpPlayers(): List[Player] = {
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
