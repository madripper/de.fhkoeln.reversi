package de.fhkoeln.reversi.view.tui

import de.fhkoeln.reversi.controller.ReversiArrayController
import scala.io.Source._
import scala.swing.Reactor

class Tui(var controller: ReversiArrayController) extends Reactor {
  listenTo(controller)
  controller.init
  printTui
 
  def printTui: Boolean = {    
    if( controller.ping || controller.gameEnd  ) {
      println({
        if( controller.whiteToken < controller.blackToken )
          "black player won."
         else if( controller.whiteToken > controller.blackToken ) 
          "white player won."
         else
           "nobody won."
      })
      false
      processInputLine("q\n")
    }
    else {
      println(controller.toString)
      println("Enter command: q-Quit n-New xy-SetCell")
      println( "Scoreboard" )
      println( "==========" )
      println( "white player has " + controller.whiteToken + " tokens" )
      println( "black player has " + controller.blackToken + " tokens" )
      println( "TurnNo. #: " + controller.turnNo )
      if( !controller.validMove && (controller.turnNo > 0 || ( controller.whiteToken == 2 && controller.blackToken == 2))) {
        println( "invalid move.." )
      }
      println(
        if (controller.switchPlayer) "black player's turn, " + controller.blackTokenMax + " tokens left: " 
        else "white player's turn, "+ controller.whiteTokenMax + " tokens left: ")
    }
    true
  }

  def processInputLine(input: String) = {
    var continue = true
    input match {
      case "q" => continue = false
      case "n" => controller.reset
                  printTui
      case _ => {
        input.filter(_.isDigit).toList.filter(c => c != ' ').map(c => c.toString.toInt) match {          
          case column :: row :: Nil => {
            controller.setCell(column-1, row-1)
            printTui
          }
          case _ => println("False Input! Input-Format: 'xy' or 'x y'")
        }
      }
    }
    continue
  }
}