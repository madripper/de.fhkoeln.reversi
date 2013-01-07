package de.fhkoeln.reversi.controller
import de.fhkoeln.reversi.model.Cell
import scala.swing.Publisher
import de.fhkoeln.reversi.model.Playboard

class ReversiArrayController( var board : Playboard ) extends Publisher {

  var switchPlayer: Boolean = false
  var playerCanMove: Boolean = false
  var validMove: Boolean = false
  var ping: Boolean = false
  var pong: Int = _
  var turnNo: Int = _
    
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
  }
  
  def reset {
    board = new Playboard( 8 )
  }
  
  def setCell( column: Int, row: Int ): Boolean = {
    val movePossible: List[(Int, Int, Int)] = board.possibleMove( column, row, switchPlayer )
    playerCanMove = if( movePossible.isEmpty ) false else true
    if( playerCanMove ) {
      for( entryCnt <- 0 to movePossible.size-1 ) {
        movePossible(entryCnt) match {
          case (column, row, _) =>                
              var lastElement: Int = movePossible(entryCnt)._3
	    	  turnNo = board.takeTurn( column, row, switchPlayer, lastElement )
	    	  
          case _ => false
        }    
      }
      switchPlayer = !switchPlayer
    }
    else ping = cantMove( turnNo )
    
    false
  }
  
  def cantMove( turnNo: Int ): Boolean = {
    if( switchPlayer ) println( "black player can't move.." ) else println( "white player can't move" )
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