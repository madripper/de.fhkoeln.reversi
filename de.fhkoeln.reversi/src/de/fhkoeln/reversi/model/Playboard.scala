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
	
  def possibleMove( column: Int, row: Int, switchPlayer: Boolean ): List[(Int, Int, Int)] =  {
    var tmpList: List[(Int, Int, Int)] = List()   
      if( board(column)(row).isEmpty )  
        for( dir <- 1 to 8 )
            if( findMove( column, row, dir, switchPlayer ) ) 
              tmpList = tmpList :+ (column, row, dir)
    tmpList.removeDuplicates
  }
  
  def possibleMoves( switchPlayer: Boolean ): List[(Int, Int, Int)] = {
    var tmpList: List[(Int, Int, Int)] = List()
    for( column <- 0 to x-1; row <- 0 to y-1 )
      tmpList = tmpList ++ possibleMove( column, row, switchPlayer )
    tmpList.removeDuplicates
  }
  
  def getPlayerDisk( column: Int, row: Int, dir: Int): Char = {    
     dir match {
	    case 1 if upLeftDiagonalCheck( left(column), up(row) ) => 
	      board( left(column))(up(row)).token
	    case 2 if upRightDiagonalCheck(right(column), up(row)) => 
	      board(right(column))(up(row)).token
	    case 3 if downRightDiagonalCheck(right(column), down(row)) => 
	      board(right(column))(down(row)).token
	    case 4 if downLeftDiagonalCheck(left(column), down(row)) => 
	      board(left(column))(down(row)).token
	    case 5 if leftCheck(left(column), row) => 
	      board(left(column))(row).token 
	    case 6 if upCheck(column, up(row)) => 
	      board(column)(up(row)).token
	    case 7 if rightCheck(right(column), row) => 
	      board(right(column))(row).token
	    case 8 if downCheck(column, down(row)) =>
	      board(column)(down(row)).token
	    case _ => '-'
	  }
  }
  
  def findMove( column: Int, row: Int, direction: Int, switchPlayer: Boolean): Boolean = {
    if( limitCheck(column, row)) {
    direction match {
      case 1 => 
        findDirectionalMove(upLeftDiagonalCheck, column, left, row, up, switchPlayer)
      case 2 =>
        findDirectionalMove(upRightDiagonalCheck, column, right, row, up, switchPlayer)
      case 3 => 
        findDirectionalMove(downRightDiagonalCheck, column, right, row, down, switchPlayer)
      case 4 => 
        findDirectionalMove(downLeftDiagonalCheck, column, left, row, down, switchPlayer)
      case 5 =>
        findDirectionalMove(leftCheck, column, left, row, none, switchPlayer)
      case 6 =>
        findDirectionalMove(upCheck, column, none, row, up, switchPlayer)
      case 7 =>
        findDirectionalMove(rightCheck, column, right, row, none, switchPlayer)
      case 8 =>
        findDirectionalMove(downCheck, column, none, row, down, switchPlayer)
      case _ => false
    }
    }
    else
      false
  }
  
  private def findDirectionalMove(check: (Int, Int) => Boolean, column: Int, dirClm: Int => Int, 
      row: Int, dirRow: Int => Int, switchPlayer: Boolean): Boolean = {
    if(check(dirClm(column), dirRow(row))) {
      
      if(board(dirClm(column))(dirRow(row)).token == (if(switchPlayer) 'W' else 'B'))
        findDirectionalMove(check, dirClm(column), dirClm, dirRow(row), dirRow, switchPlayer)
      else if(check(dirClm(column), dirRow(row)) && board(dirClm(column))(dirRow(row)).token == (if(switchPlayer) 'B' else 'W')) true
      else false
    }
    else false
  }
  
  def updateBoard( column: Int, row: Int, switchPlayer: Boolean ) {                                               
    update( column, row, if( switchPlayer ) 'B' else 'W' )

    //for( dir <- 1 to 8 )
    var dir: Int = whichDir
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
  
  private def updateBoardPositions(check: (Int, Int) => Boolean, column: Int, dirClm: Int => Int, 
    row: Int, dirRow: Int => Int, switchPlayer: Boolean) {
    println( whichDir )
    if (check(dirClm(column), dirRow(row)) )
      if(board(dirClm(column))(dirRow(row)).token == (if( switchPlayer ) 'B' else 'W' ) ) {
        board(dirClm(column))(dirRow(row)).update( (if( switchPlayer ) 'W' else 'B'))
        updateBoardPositions(check, dirClm(column), dirClm, dirRow(row), dirRow, switchPlayer)
    }
  }
  
  var whichDir: Int = _
  
  def takeTurn(  column: Int, row: Int, switchPlayer: Boolean, whichDir: Int ): Int = {
    this.whichDir = whichDir
    takeTurn( column, row, switchPlayer )
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