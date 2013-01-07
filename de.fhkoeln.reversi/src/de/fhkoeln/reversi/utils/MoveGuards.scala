package de.fhkoeln.reversi.utils

trait MoveGuards {

  val upperLimit, leftLimit = 0
  val lowerLimit, rightLimit = 7

  // Guards that check that the given indeces are within the board limits
  val upLeftDiagonalCheck = (column: Int, row: Int) => column >= leftLimit && row >= upperLimit 	//1
  val upRightDiagonalCheck = (column: Int, row: Int) => column <= rightLimit && row >= upperLimit //2
  val downRightDiagonalCheck = (column: Int, row: Int) => column <= rightLimit && row <= lowerLimit//3
  val downLeftDiagonalCheck = (column: Int, row: Int) => column >= leftLimit && row <= lowerLimit  //4
  val leftCheck = (column: Int, row: Int) => column >= leftLimit //5
  val upCheck = (column: Int, row: Int) => row >= upperLimit //6
  val rightCheck = (column: Int, row: Int) => column <= rightLimit //7
  val downCheck = (column: Int, row: Int) => row <= lowerLimit//8
  val limitCheck = (column: Int, row: Int) => leftLimit <= column && column <= rightLimit && upperLimit <= row && row <= lowerLimit

  // Directional movements
  val left, up = (x: Int) => x - 1
  val right, down = (x: Int) => x + 1 
  val none = (x: Int) => x
}
