package de.fhkoeln.reversi.view.tui

import de.fhkoeln.reversi.controller.ReversiArrayController
import scala.io.Source._
import scala.swing.Reactor

/**
 * <pre>
 * <b>Class <i>Tui</i></b>
 *
 * </pre>
 */
class Tui(var controller: ReversiArrayController) extends Reactor {
  listenTo(controller)
  
/*  reactions += {
    case e: RestartGame => printTui
  }
*/
  controller.init
  printTui
  
  /**
   * <pre>
   * <b><i>printTui</i></b>
   * Method generates the output for the console.
   * </pre>
   */
  def printTui = {
    
    println(controller.toString)
    println("Enter command: q-Quit n-New xy-SetCell")
    println(if (controller.switchPlayer) "black player's turn: " else "white player's turn:")
  }

  def processInputLine(input: String) = {
    var continue = true
    input match {
      case "q" => continue = false
      case "n" => controller.reset
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
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