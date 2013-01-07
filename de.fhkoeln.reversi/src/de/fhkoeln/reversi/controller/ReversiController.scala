package de.fhkoeln.reversi.controller
import de.fhkoeln.reversi.model.Grid
import scala.swing.Publisher

class ReversiController( var grid : Grid ) extends Publisher {

  var switchPlayer: Boolean = false
    
  /**
   * <pre><b><i>init</i></b>
   * This Method initilize the playboard 
   * with the default values.
   * </pre>
   */  
  def init {
    grid.update( 4, 4, 'W' )
    grid.update( 5, 5, 'W' )
    grid.update( 4, 5, 'B' )
    grid.update( 5, 4, 'B' )
  }
  
  def reset {
    grid = new Grid( 8 )
  }
  
  def setCell( column: Int, row: Int ): Boolean = {
    if( grid.isFieldEmpty(column, row) ) {
      grid.update( column, row, if( switchPlayer ) 'B' else 'W' )    
      switchPlayer = !switchPlayer
      true 
    } 
    else {
      println( "Field is not empty. Try another Field.." )
      false
    }
  }
  
  def isFieldEmpty( column: Int, row: Int ): Boolean = {
    grid.isFieldEmpty(column, row)
  }
  
  def getTokenFrom( column: Int, row: Int ): Char = {
    grid.getTokenFrom(column, row)
  }
  
  override def toString = ( grid.toString )
}