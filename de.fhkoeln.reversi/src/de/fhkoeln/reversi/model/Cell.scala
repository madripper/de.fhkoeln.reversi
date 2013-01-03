package de.fhkoeln.reversi.model

/**
 * 
 * x: Spalten / row
 * y: Zeilen / column
 * isSet: Ist die Zelle mit einem Stein belegt? --> true: belegt; false: unbelegt
 *         Is there a token on the cell? --> true: occupied; false: unoccupied 
 * isWhite: Liegt ein weißer Stein auf dem Feld? --> true: weißer Stein; false: Wenn isSet == true: schwarzer Stein. Sonst: unbelegt.
 *          Is there a white token on the cell? --> true: white token; false: when isSet == true, then black token, else unoccupied
 * isBlack: Liegt ein schwarzer Stein auf dem Feld? --> true: schwarzer Stein; flase: Wenn isSet == true: weißer Stein. Sonst: unbelegt.
 *          Is there a black token on the cell? --> true: black token; false: when isSet == true, then white token, else unoccupied 
 */
class Cell( val x: Int, val y: Int, val isSet: Boolean, val isWhite: Boolean ) {
  val isBlack = !isWhite && isSet
  var overrideString: String = " "
    
  if( isSet ) {
    if( isWhite ) overrideString = "o" else overrideString = "*"
  }
  override def toString = ( overrideString )
}


