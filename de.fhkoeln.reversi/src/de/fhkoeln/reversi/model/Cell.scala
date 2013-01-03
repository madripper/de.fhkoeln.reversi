package de.fhkoeln.reversi.model

/**
 * 
 * x: Zeilen / column
 * y: Spalten / row
 * isUsed: Ist die Zelle mit einem Stein belegt? --> true: belegt; false: unbelegt
 *         Is there a token on the cell? --> true: occupied; false: unoccupied 
 * isWhite: Liegt ein weißer Stein auf dem Feld? --> true: weißer Stein; false: schwarzer Stein
 *          Is there a white token on the cell? --> true: white token; false: black token
 */
class Cell( val x: Int, val y: Int, val isUsed: Boolean, val isWhite: Boolean ) {
  
  override def toString = ("Cell( x= " + x + ", y= " + y + ", isUsed= " + isUsed + ", isWhite= " + isWhite + ")" )
}