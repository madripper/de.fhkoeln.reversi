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
  
  var whichDir: Int = _
  
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
  
  def updateBoard( column: Int, row: Int, switchPlayer: Boolean ): Boolean = {         
    var dir: Int = whichDir
        var isUpdated: Boolean = dir match {
          case 1 =>
            updateBoardPositions(upLeftDiagonalCheck, column, left, row, up, switchPlayer)
          case 2 =>
            updateBoardPositions(upRightDiagonalCheck, column, right, row, up, switchPlayer)
          case 3 =>
            updateBoardPositions(downRightDiagonalCheck, column, right, row, down, switchPlayer)
          case 4 =>
            updateBoardPositions(downLeftDiagonalCheck, column, left, row, down, switchPlayer)
          case 5 =>
            updateBoardPositions(leftCheck, column, left, row, none, switchPlayer)
          case 6 =>
            updateBoardPositions(upCheck, column, none, row, up, switchPlayer)
          case 7 =>
            updateBoardPositions(rightCheck, column, right, row, none, switchPlayer)
          case 8 =>
            updateBoardPositions(downCheck, column, none, row, down, switchPlayer)
          case _ => 
            false
        }
    println( " - Update: " + isUpdated )
    if( isUpdated ) {
      update( column, row, if( switchPlayer ) 'B' else 'W' )
      true
    }
    else false
  } 
  
  private def updateBoardPositions(check: (Int, Int) => Boolean, column: Int, dirClm: Int => Int, 
    row: Int, dirRow: Int => Int, switchPlayer: Boolean): Boolean = {
        print( column, row, whichDir )
        print( "switchPlayer: " + switchPlayer + " - Check: " + check(dirClm(column), dirRow(row)) + " - Token: " + board(dirClm(column))(dirRow(row)).token + " ")
    if(check(dirClm(column), dirRow(row)) && board(dirClm(column))(dirRow(row)).token == (if( switchPlayer ) 'W' else 'B' ) ) {
        print( " - Old Token: " + board(dirClm(column))(dirRow(row)).token + " " )
        board(dirClm(column))(dirRow(row)).update( (if( switchPlayer ) 'B' else 'W'))
        print( " - new Token: " + board(dirClm(column))(dirRow(row)).token + " " )
        updateBoardPositions(check, dirClm(column), dirClm, dirRow(row), dirRow, switchPlayer)
        true
    }
    else false
  }
    
  def takeTurn(  column: Int, row: Int, switchPlayer: Boolean, whichDir: Int ): Boolean = {
    this.whichDir = whichDir
    takeTurn( column, row, switchPlayer )
  }
  
  def takeTurn( column: Int, row: Int, switchPlayer: Boolean ): Boolean = {
    var updateSuccess: Boolean = updateBoard( column, row, switchPlayer ) 
    if( updateSuccess ) {
      turnNo = turnNo + 1
    }
    updateSuccess
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