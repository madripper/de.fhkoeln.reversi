package de.fhkoeln.reversi.model

import de.fhkoeln.reversi.utils.MoveGuards

/**
 * <pre>
 * <b>Class <i>Playboard</i></b>
 * 
 * </pre>
 */
class Playboard(val board: Array[Array[Cell]]) extends MoveGuards {
  /**
   * <pre>
   * <b><i>Constructor</i></b>
   * Overloads the Constructor.
   * </pre>
   */
  def this(blocksize: Int) = this { 
    var blckSize: Int = blocksize
    if( blocksize < 4 ) { blckSize = 4 } else if( blocksize % 2 != 0 ) { blckSize = blocksize - 1 }
    Array.fill( blckSize, blckSize )(new Cell('-'))
  }
  
  var x: Int = board.size
  var y: Int = board.head.size
  var size: Int = x * y
  var blocknum: Int = board.size
  var turnNo: Int = _
  
  def isFieldEmpty( column: Int, row: Int ): Boolean = {
    board( column )( row ).isEmpty	  
  }
	
  def getTokenFrom( column: Int, row: Int ): Char = {
    board( column )( row ).token
  }
	
  def getStringFrom( column: Int, row: Int ): String = {
    "+---+\n| " + board( column )( row ).toString + " |\n+---+"
  }
	
  def update( column: Int, row: Int, token: Char ) {
    board( column )( row ).update(token)
  }
	
  def possibleMove( column: Int, row: Int, switchPlayer: Boolean ): List[Int] =  {
    var tmpList: List[Int] = List[Int]()
    for( i <- 0 to x-1; j <- 0 to y-1 ){
      if( board(i)(j).isEmpty ){
        for( dir <- 1 to 8 ) {
          if( getPlayerDisk( column, row, dir ) == (if( switchPlayer ) 'B' else 'W' )) {
            if( findMove( column, row, dir, switchPlayer ) ) {
              tmpList = tmpList :+ (column*10+row)
            }
          }
        }
        
      }
        
    }
    tmpList
  }
  
  private def getPlayerDisk(i: Int, j: Int, dir: Int): Char = dir match {
    case 1 if upLeftDiagonalCheck(up(i), left(j)) => 
      board(up(i))(left(j)).token
    case 2 if upRightDiagonalCheck(up(i), right(j)) => 
      board(up(i))(right(j)).token
    case 3 if downRightDiagonalCheck(down(i), right(j)) => 
      board(down(i))(right(j)).token
    case 4 if downLeftDiagonalCheck(down(i), left(j)) => 
      board(down(i))(left(j)).token
    case 5 if leftCheck(i, left(j)) => 
      board(i)(left(j)).token 
    case 6 if upCheck(up(i), j) => 
      board(up(i))(j).token
    case 7 if rightCheck(i, right(j)) => 
      board(i)(right(j)).token
    case 8 if downCheck(down(i), j) => 
      board(down(i))(j).token
    case _ => '-'
  }
  
  private def findMove(i: Int, j: Int, direction: Int, player: Boolean): Boolean = {
    direction match {
      case 1 => 
        findDirectionalMove(upLeftDiagonalCheck, i, up, j, left, player)
      case 2 =>
        findDirectionalMove(upRightDiagonalCheck, i, up, j, right, player)
      case 3 => 
        findDirectionalMove(downRightDiagonalCheck, i, down, j, right, player)
      case 4 => 
        findDirectionalMove(downLeftDiagonalCheck, i, down, j, left, player)
      case 5 =>
        findDirectionalMove(leftCheck, i, none, j, left, player)
      case 6 =>
        findDirectionalMove(upCheck, i, up, j, none, player)
      case 7 =>
        findDirectionalMove(rightCheck, i, none, j, right, player)
      case 8 =>
        findDirectionalMove(downCheck, i, down, j, none, player)
    }
  }
  
  private def findDirectionalMove(check: (Int, Int) => Boolean, i: Int, dirI: Int => Int,
    j: Int, dirJ: Int => Int, currPlayer: Boolean): Boolean = {  
    if (check(dirI(i), dirJ(j)) && board(i)(j).token == (if(currPlayer) 'B' else 'W'))
      findDirectionalMove(check, dirI(i), dirI, dirJ(j), dirJ, currPlayer)
    else if(check(dirI(i), dirJ(j)) && board(i)(j).token != (if(currPlayer) 'B' else 'W')) true
    else false
  }
  
  def updateBoard( column: Int, row: Int, switchPlayer: Boolean ) {                                               
    update( column, row, if( switchPlayer ) 'B' else 'W' )

         for( dir <- 1 to 8 )
        dir match {
          case 1 =>
            updateBoardPositions(upLeftDiagonalCheck, column, up, row, left, switchPlayer)
          case 2 =>
            updateBoardPositions(upRightDiagonalCheck, column, up, row, right, switchPlayer)
          case 3 =>
            updateBoardPositions(downRightDiagonalCheck, column, down, row, right, switchPlayer)
          case 4 =>
            updateBoardPositions(downLeftDiagonalCheck, column, down, row, left, switchPlayer)
          case 5 =>
            updateBoardPositions(leftCheck, column, none, row, left, switchPlayer)
          case 6 =>
            updateBoardPositions(upCheck, column, up, row, none, switchPlayer)
          case 7 =>
            updateBoardPositions(rightCheck, column, none, row, right, switchPlayer)
          case 8 =>
            updateBoardPositions(downCheck, column, down, row, none, switchPlayer)
        }
      
    
  } 
  
  private def updateBoardPositions(check: (Int, Int) => Boolean, i: Int, dirI: Int => Int, 
    j: Int, dirJ: Int => Int, switchPlayer: Boolean) {
    if (check(dirI(i), dirJ(j)) && (board(i)(j).token == (if( switchPlayer ) 'W' else 'B' ) )) {
      board(dirI(i))(dirJ(j)).update( (if( switchPlayer ) 'B' else 'W'))
      updateBoardPositions(check, dirI(i), dirI, dirJ(j), dirJ, switchPlayer)
    }
  }
  
  def takeTurn( column: Int, row: Int, switchPlayer: Boolean ): Int = {
    updateBoard( column, row, switchPlayer )
    turnNo = turnNo + 1
    turnNo
  }
		
  override def toString: String = {
    val columnNumbers: String = {
      var colNum: String = ""
      for( i <- 1 to blocknum )  colNum = colNum + ("  " + i + (if( i < 10 ) " " else "") )
      colNum
    } 
    
    var box: String = {
      val lineseparator = ("+---") * blocknum + "+\n"
      var boxString: String = "\n  " + columnNumbers + "\n"
      for( i <- 1 to blocknum ) boxString = boxString + "  " + lineseparator + i + " | x" * blocknum + " |\n"
      boxString = boxString + "  " + lineseparator
      boxString
    }
    for (row <- 0 to y-1; column <- 0 to x-1) {
      (box = box.replaceFirst("x", getTokenFrom(column, row).toString))
    }
    box
  }
}