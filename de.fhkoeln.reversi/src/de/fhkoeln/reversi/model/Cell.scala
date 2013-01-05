package de.fhkoeln.reversi.model

/**
 * isEmpty: Ist die Zelle mit einem Stein belegt? --> true: belegt; false: unbelegt
 *          Is there a token on the cell? --> true: occupied; false: unoccupied 
 */
class Cell( colour: Char ) {
  var isEmpty: Boolean = true
  var overrideString: String = "-"
  var token: Char = '-'
  
  colour match {
    case 'W' => overrideString = "W" // Weißer Stein / white token
                isEmpty = false
                token = 'W'
    case 'B' => overrideString = "B" // Schwarzer Stein / black token
                isEmpty = false
                token = 'B'
    case '-' => overrideString = "-" // kein Stein / no token
      			isEmpty = true
      			token = '-'
    case _   => overrideString = "-" // default: kein Stein
                isEmpty = true
      			token = '-'
  }
  
  override def toString = ( overrideString )
}


