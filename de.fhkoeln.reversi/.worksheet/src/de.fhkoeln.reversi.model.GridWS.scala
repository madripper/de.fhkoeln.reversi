package de.fhkoeln.reversi.model

import scala.math.sqrt
object GridWS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
  println("+---+\n|   |\n+---+");$skip(42); 
            
  var expString: String = "";System.out.println("""expString  : String = """ + $show(expString ));$skip(21); 
  var size: Int = 64;System.out.println("""size  : Int = """ + $show(size ));$skip(36); 
  var max: Int = sqrt( size ).toInt;System.out.println("""max  : Int = """ + $show(max ));$skip(24); 
  
  var blocknum = max;System.out.println("""blocknum  : Int = """ + $show(blocknum ));$skip(50); 
  val lineseparator = ("+---") * blocknum + "+\n";System.out.println("""lineseparator  : java.lang.String = """ + $show(lineseparator ));$skip(193); 
  //val line = ("| - ") * blocknum + "|\n"
  val line: String = {
    var rowNmbr: String = ""
    for( i <- 1 to max ) rowNmbr = rowNmbr + " " + i + " | - " * blocknum + "|\n"
    rowNmbr
  };System.out.println("""line  : String = """ + $show(line ));$skip(25); 

  val columnNumbers = 6;System.out.println("""columnNumbers  : Int = """ + $show(columnNumbers ));$skip(305); 
  
  var box: String = {
    val lineseparator = ("+---") * blocknum + "+\n"
    var boxString: String = "\n  " + columnNumbers + "\n"
    for( i <- 1 to max ) boxString = boxString + "  " + lineseparator + i + " | -" * blocknum + " |\n"
    boxString = boxString + "  " + lineseparator
    boxString
  };System.out.println("""box  : String = """ + $show(box ));$skip(493); 
  
  
  
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
  };$skip(23); 
  println( expString );$skip(51); 
  
  var board = Array.fill( 9, 8 )(new Cell('-'));System.out.println("""board  : Array[Array[de.fhkoeln.reversi.model.Cell]] = """ + $show(board ));$skip(13); val res$0 = 
  board.size;System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  board.length;System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
  board.head.size;System.out.println("""res2: Int = """ + $show(res$2));$skip(14); val res$3 = 
  board(5)(3);System.out.println("""res3: de.fhkoeln.reversi.model.Cell = """ + $show(res$3));$skip(180); 
  
  var ilist: List[(Int, Int, Int)] = {
    var retL: List[(Int, Int, Int)]  = List()
    for( i <- 1 to 5; j <- 1 to 3; k <- 1 to 3 )
      retL = retL :+ (i, j, k)

	  retL
	};System.out.println("""ilist  : List[(Int, Int, Int)] = """ + $show(ilist ));$skip(107); 
	for( cnt <- 0 to ilist.size-1 )
  ilist(cnt) match {
    case (1, 1, _) => println( ilist(cnt) )
    
  }}

}