package com.tamminhdao.ttt

object Validator {
  def validate(board: Vector[Symbol], userInput: String):Boolean = {
    val typeRange = validateTypeAndRange(board, userInput)
    typeRange match {
      case true => cellAvailable(board, userInput)
      case false => false
    }
  }

  private def validateTypeAndRange(board: Vector[Symbol], userInput: String): Boolean = {
    val formattedInput = convertStringToOptional(userInput)
    val typeCheck = validateType(formattedInput)
    typeCheck match {
      case false => false
      case true => validateRange(board, formattedInput)
    }
  }

  private def cellAvailable(board: Vector[Symbol], userInput: String): Boolean = {
    val avail = Board.cellIsEmpty(board, userInput.toInt)
    avail
  }

  private def convertStringToOptional(userInput: String): Option[Int] = {
    try {
      Some(userInput.toInt)
    } catch {
      case e: Exception => None
    }
  }

  private def validateType(userInput: Option[Int]): Boolean = {
    userInput match {
      case None => false
      case _ => true
    }
  }

  private def validateRange(board: Vector[Symbol], userInput: Option[Int]): Boolean = {
    val maxIndex = board.length
    if (0 <= userInput.get && userInput.get < maxIndex)
      true
    else
      false
  }
}
