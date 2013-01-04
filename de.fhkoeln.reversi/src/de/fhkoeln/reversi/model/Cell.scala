package de.fhkoeln.reversi.model

/**
 * isEmpty: Ist die Zelle mit einem Stein belegt? --> true: belegt; false: unbelegt
 *          Is there a token on the cell? --> true: occupied; false: unoccupied 
 */
class Cell( val colour: Char ) {
  var isEmpty: Boolean = true
  var overrideString: String = " "
  var token: Char = colour
  
  colour match {
    case 'W' => overrideString = "W" // Weißer Stein / white token
                isEmpty = false
    case 'B' => overrideString = "B" // Schwarzer Stein / black token
                isEmpty = false
    case '-' => overrideString = " " // kein Stein / no token
      			isEmpty = true
  }
  
  override def toString = ( overrideString )
}


