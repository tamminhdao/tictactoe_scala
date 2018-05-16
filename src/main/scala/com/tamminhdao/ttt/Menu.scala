package com.tamminhdao.ttt

object Menu {
  def welcomeMessage(): Unit = {
    IO.publishOutput(Message.welcome())
  }

  def start(): Unit = {
    val gameType = IO.obtainInput(Message.selectGameType())
    gameType match {
      case "1" => humanVsHuman()
      case "2" => AIvsHuman()
      case "3" => humanVsAI()
      case _ => start()
    }
  }

  private def humanVsHuman(): Unit = {
    IO.publishOutput(Message.humanVsHuman())
    val ttt = new Game()
    val emptyBoard = Board.newBoard(3)
    val player1 = new HumanPlayer()
    val player2 = new HumanPlayer()
    val players = List(player1, player2)
    val symbols = List('X, 'O)
    ttt.play(emptyBoard, players, symbols)
  }

  private def AIvsHuman(): Unit = {
    IO.publishOutput(Message.AIVsHuman())
    val ttt = new Game()
    val emptyBoard = Board.newBoard(3)
    val player1 = new AIPlayer()
    val player2 = new HumanPlayer()
    val players = List(player1, player2)
    val symbols = List('X, 'O)
    ttt.play(emptyBoard, players, symbols)
  }

  private def humanVsAI(): Unit = {
    IO.publishOutput(Message.humanVsAI())
    val ttt = new Game()
    val emptyBoard = Board.newBoard(3)
    val player1 = new HumanPlayer()
    val player2 = new AIPlayer()
    val players = List(player1, player2)
    val symbols = List('O, 'X)
    ttt.play(emptyBoard, players, symbols)
  }
}
