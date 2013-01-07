package de.fhkoeln.reversi.model

/**
 * isEmpty: Ist die Zelle mit einem Stein belegt? --> true: belegt; false: unbelegt
 *          Is there a token on the cell? --> true: occupied; false: unoccupied 
 */
class Cell( colour: Char ) {
  var isEmpty: Boolean = _
  var overrideString: String = _
  var token: Char = _
  
  colour match {
    case 'W' => update( colour )
    case 'B' => update( colour )
    case '-' => update( colour )
                isEmpty = true
    case _   => update( '-' )
                isEmpty = true
  }
  
  def update( token: Char ) {
    this.overrideString = token.toString
    this.isEmpty = false
    this.token = token
  }
  
  override def toString = ( overrideString )
}
