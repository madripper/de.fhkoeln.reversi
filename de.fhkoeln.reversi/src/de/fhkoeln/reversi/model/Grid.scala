package de.fhkoeln.reversi.model

import scala.math.sqrt

class Grid( cells: Vector[Cell] ) {
  // def this Ersetzt die if-statements bei denen ein neuer Vektor erzeugt wurde, 
  // wenn die Grid-Groesse kleiner als 4 Elemente oder mit einer ungerader Anzahl
  // Elemente aufgerufen wird.
  def this(blocksize: Int) = this { 
    var blckSize: Int = blocksize
    if( blocksize < 4 ) { blckSize = 4 } else if( blocksize % 2 != 0 ) { blckSize = blocksize - 1 }
    Vector.fill( blckSize * blckSize )(new Cell('-'))
  }
	var size: Int = cells.size
	var x: Int = sqrt( size ).toInt
	var y: Int = sqrt( size ).toInt
	var blocknum: Int = sqrt( size ).toInt
	
	/** TODO entfernen
	 * Korrekturen werden oben im def this (Konstruktor..) durchgeführt 
	if( sqrt( size ).toInt < 4 ) {
	  size = 16
	  x = sqrt( size ).toInt
	  y = sqrt( size ).toInt
	  blocknum = sqrt( size ).toInt
	  createField( size )
	}
	
	if( size % 2 != 0 ) {
	  size = cells.size
	  x = sqrt( size ).toInt
	  y = sqrt( size ).toInt
	  blocknum = sqrt( size ).toInt
	  createField( size )
	}
	
	def createField( size: Int ) {
	  
	  for( i <- 0 to (size-1) ) {
	    //cells = cells :+ new Cell( '-' )
	  }
	  //cells = Vector.fill( size )(new Cell(0))
	}
	*/
	
	def isFieldEmpty( column: Int, row: Int ): Boolean = {
	  runFields( column, row ).isEmpty	  
	}
	
	def getTokenFrom( column: Int, row: Int ): Char = {
	  runFields( column, row ).token
	}
	
	def getStringFrom( column: Int, row: Int ): String = {
	  "+---+\n| " + runFields( column, row ).toString + " |\n+---+"
	}
	
	def runFields( column: Int, row: Int ): Cell = {
	  cells( (column - 1) + ((row - 1) * x )  )	  
	}
	
	def update( column: Int, row: Int, token: Char ) {
	  var cell: Cell = runFields( column, row )
	  cell.isEmpty = false
	  cell.token = token
	}
	
	override def toString = {
	  val lineseparator: String = ("+---") * blocknum + "+\n" 
      val line: String = ("| x ") * blocknum + "|\n"        
      var box: String = "\n" + (lineseparator + (line)) * blocknum + lineseparator
      for (row <- 1 to y; column <- 1 to x) {
        (box = box.replaceFirst("x", getTokenFrom(column, row).toString))
      }
      box
      }
}