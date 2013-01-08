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

  val columnNumbers = 6                           //> columnNumbers  : Int = 6
  
  var box: String = {
    val lineseparator = ("+---") * blocknum + "+\n"
    var boxString: String = "\n  " + columnNumbers + "\n"
    for( i <- 1 to max ) boxString = boxString + "  " + lineseparator + i + " | -" * blocknum + " |\n"
    boxString = boxString + "  " + lineseparator
    boxString
  }                                               //> box  : String = "
                                                  //|   6
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
  
  var ilist: List[(Int, Int, Int)] = {
    var retL: List[(Int, Int, Int)]  = List()
    for( i <- 1 to 5; j <- 1 to 3; k <- 1 to 3 )
      retL = retL :+ (i, j, k)

	  retL
	}                                         //> ilist  : List[(Int, Int, Int)] = List((1,1,1), (1,1,2), (1,1,3), (1,2,1), (
                                                  //| 1,2,2), (1,2,3), (1,3,1), (1,3,2), (1,3,3), (2,1,1), (2,1,2), (2,1,3), (2,2
                                                  //| ,1), (2,2,2), (2,2,3), (2,3,1), (2,3,2), (2,3,3), (3,1,1), (3,1,2), (3,1,3)
                                                  //| , (3,2,1), (3,2,2), (3,2,3), (3,3,1), (3,3,2), (3,3,3), (4,1,1), (4,1,2), (
                                                  //| 4,1,3), (4,2,1), (4,2,2), (4,2,3), (4,3,1), (4,3,2), (4,3,3), (5,1,1), (5,1
                                                  //| ,2), (5,1,3), (5,2,1), (5,2,2), (5,2,3), (5,3,1), (5,3,2), (5,3,3))
	for( cnt <- 0 to ilist.size-1 )
  ilist(cnt) match {
    case (1, 1, _) => println( ilist(cnt) )
    
  }                                               //> (1,1,1)
                                                  //| (1,1,2)
                                                  //| (1,1,3)
                                                  //| scala.MatchError: (1,2,1) (of class scala.Tuple3)
                                                  //| 	at de.fhkoeln.reversi.model.GridWS$$anonfun$main$1$$anonfun$apply$mcV$sp
                                                  //| $2.apply$mcVI$sp(de.fhkoeln.reversi.model.GridWS.scala:63)
                                                  //| 	at scala.collection.immutable.Range.foreach$mVc$sp(Range.scala:78)
                                                  //| 	at de.fhkoeln.reversi.model.GridWS$$anonfun$main$1.apply$mcV$sp(de.fhkoe
                                                  //| ln.reversi.model.GridWS.scala:62)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at de.fhkoeln.reversi.model.GridWS$.main(de.fhkoeln.reversi.model.GridWS
                                                  //| .scala:4)
                                                  //| 	at de.fhkoeln.reversi.model.GridWS.main(de.fhkoeln.reversi.model.GridWS.
                                                  //| scala)

}