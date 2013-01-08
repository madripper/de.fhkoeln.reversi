package de.fhkoeln.reversi.controller
import de.fhkoeln.reversi.model.Cell
import scala.swing.Publisher
import de.fhkoeln.reversi.model.Playboard

class ReversiArrayController( var board : Playboard ) extends Publisher {

  var switchPlayer: Boolean = false
  var playerCanMove: Boolean = false
  var validMove: Boolean = true
  var ping: Boolean = false
  var pong: Int = _
  var turnNo: Int = _
  var whiteToken: Int = _
  var blackToken: Int = _
  var whiteTokenMax: Int = 32
  var blackTokenMax: Int = 32
  var gameEnd: Boolean = (whiteTokenMax == 0) && (blackTokenMax == 0)
    
  /**
   * <pre><b><i>init</i></b>
   * This Method initilize the playboard 
   * with the default values.
   * </pre>
   */  
  def init {
    board.update( (board.x/2)-1, (board.y/2)-1, 'W' )
    board.update( (board.x/2),   (board.y/2), 'W' )
    board.update( (board.x/2)-1, (board.y/2), 'B' )
    board.update( (board.x/2),   (board.y/2)-1, 'B' )
    whiteToken = 2
    blackToken = 2
  }
  
  def reset {
    board.reset
    init
    switchPlayer = false
    playerCanMove = false
    validMove = true
    ping = false
    pong = 0
    turnNo = 0
  }
  
  def setCell( column: Int, row: Int ): Boolean = {
    val movePossible: List[(Int, Int, Int)] = board.possibleMove( column, row, switchPlayer )
    val movesPossible: List[(Int, Int, Int)] = board.possibleMoves( switchPlayer )
    playerCanMove = if( movePossible.isEmpty ) false else true
    var updateSuccess: Boolean = false
    if( playerCanMove ) {      
        for( entryCnt <- 0 to movePossible.size-1 ) {
          movePossible(entryCnt) match {
            case (column, row, _) =>
                updateSuccess = board.takeTurn( column, row, switchPlayer, movePossible(entryCnt)._3 )
                turnNo = board.turnNo                 
            case _ => updateSuccess = false
          }    
        }
      
    }
    else if( !movesPossible.isEmpty ) {
      validMove = false
    }
    else {
      ping = cantMove( turnNo )
      switchPlayer = !switchPlayer
    }
    
    if( updateSuccess ) {      
      if( switchPlayer ) {        
        blackTokenMax = blackTokenMax - 1
        //blackToken = blackToken + board.tokensTurned + 1
        //whiteToken = whiteToken - board.tokensTurned
      }
      else {
        whiteTokenMax = whiteTokenMax - 1
        //blackToken = blackToken - board.tokensTurned
        //whiteToken = whiteToken + board.tokensTurned +1
      }
      whiteToken = 0
        blackToken = 0
      for( column: Int <- 0 to board.x-1; row: Int <- 0 to board.y-1 ) {
        
        if( board.getTokenFrom(column, row) == 'W' ) whiteToken = whiteToken + 1 
        if( board.getTokenFrom(column, row) == 'B' ) blackToken = blackToken + 1
      }
      
      switchPlayer = !switchPlayer
      validMove = true
    }

    updateSuccess    
  }
  
  def cantMove( turnNo: Int ): Boolean = {
    if( pong == turnNo ) true else { pong = turnNo; false}
  }
  
  def isFieldEmpty( column: Int, row: Int ): Boolean = {
    board.isFieldEmpty(column, row)
  }
  
  def getTokenFrom( column: Int, row: Int ): Char = {
    board.getTokenFrom(column, row)
  }
  
  override def toString = ( board.toString )
}