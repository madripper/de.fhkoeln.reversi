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
  //val line = ("| - ") * blocknum + "|\n"
  val line: String = {
    var rowNmbr: String = ""
    for( i <- 1 to max ) rowNmbr = rowNmbr + " " + i + " | - " * blocknum + "|\n"
    rowNmbr
  }                                               //> line  : String = " 1 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  2 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  3 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  4 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  5 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  6 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  7 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //|  8 | -  | -  | -  | -  | -  | -  | -  | - |
                                                  //| "
  
  
  val columnNumbers: String = {
  var colNum: String = ""
  for( i <- 1 to max )  colNum = colNum + ("  " + i + (if( i < 10 ) " " else "") )
  colNum
  
  }                                               //> columnNumbers  : String = "  1   2   3   4   5   6   7   8 "
  
  var box: String = {
    val lineseparator = ("+---") * blocknum + "+\n"
    var boxString: String = "\n  " + columnNumbers + "\n"
    for( i <- 1 to max ) boxString = boxString + "  " + lineseparator + i + " | -" * blocknum + " |\n"
    boxString = boxString + "  " + lineseparator
    boxString
  }                                               //> box  : String = "
                                                  //|     1   2   3   4   5   6   7   8 
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 1 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 2 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 3 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 4 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 5 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 6 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 7 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| 8 | - | - | - | - | - | - | - | - |
                                                  //|   +---+---+---+---+---+---+---+---+
                                                  //| "
  
  
  
  //var box = "\n  " + columnNumbers + "\n" + ("  " + lineseparator + "" + (line)) * blocknum + "  " + lineseparator
  
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
  
  var board = Array.fill( 9, 8 )(new Cell('-'))   //> board  : Array[Array[de.fhkoeln.reversi.model.Cell]] = Array(Array(-, -, -,
                                                  //|  -, -, -, -, -), Array(-, -, -, -, -, -, -, -), Array(-, -, -, -, -, -, -, 
                                                  //| -), Array(-, -, -, -, -, -, -, -), Array(-, -, -, -, -, -, -, -), Array(-, 
                                                  //| -, -, -, -, -, -, -), Array(-, -, -, -, -, -, -, -), Array(-, -, -, -, -, -
                                                  //| , -, -), Array(-, -, -, -, -, -, -, -))
  board.size                                      //> res0: Int = 9
  board.length                                    //> res1: Int = 9
  board.head.size                                 //> res2: Int = 8
  board(5)(3)                                     //> res3: de.fhkoeln.reversi.model.Cell = -
  
  

}