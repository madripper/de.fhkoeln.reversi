package de.fhkoeln.reversi.model

import scala.math.sqrt
object GridWS {
  println("+---+\n|   |\n+---+")                  //> +---+
                                                  //| |   |
                                                  //| +---+
            
  var expString: String = ""                      //> expString  : String = ""
  var size: Int = 64                              //> size  : Int = 64
  var max: Int = sqrt( size ).toInt               //> max  : Int = 8
  
  var blocknum = max                              //> blocknum  : Int = 8
  val lineseparator = ("+---") * blocknum + "+\n" //> lineseparator  : java.lang.String = "+---+---+---+---+---+---+---+---+
                                                  //| "
  val line = ("| - ") * blocknum + "|\n"          //> line  : java.lang.String = "| - | - | - | - | - | - | - | - |
                                                  //| "
  var box = "\n" + (lineseparator + (line)) * blocknum + lineseparator
                                                  //> box  : java.lang.String = "
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| | - | - | - | - | - | - | - | - |
                                                  //| +---+---+---+---+---+---+---+---+
                                                  //| "
  
  for( i <- 0 to max*2; j <- 0 until max; k <- 0 to 3 ) {
  
  /**
  if( j % max == 0 ) {
    if( k % 4 == 0 ) expString = expString + "+"
    else expString = expString + "."
  }
  else { if( k % 4 == 0 ) expString = expString + "|" else expString = expString + "." }
    if( j % max != 0 && k % 4 != 0 ) {
      expString = expString + "\n"
    }
    **/
  }
  println( expString )                            //> 
}