package de.fhkoeln.reversi.controller
import de.fhkoeln.reversi.model.Grid
import scala.swing.Publisher

class ReversiController( var grid : Grid ) extends Publisher {

  def reset {
    
  }
  
  def setCell( column: Int, row: Int ) {
    grid.update( column, row, 'W' )
    println( grid.toString )
  }
}