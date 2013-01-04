package de.fhkoeln.reversi.view.tui

import de.fhkoeln.reversi.controller.ReversiController
import scala.io.Source._
import scala.swing.Reactor

class Tui( var controller: ReversiController ) extends Reactor {
  listenTo( controller )
  printTui
  def printTui = {
    println( controller.grid.toString )
    println("Enter command: q-Quit n-New xy-SetCell")
  }
 def processInputLine(input: String) = {
   var continue = true
   input match {
      case "q" => continue = false
      case "n" => controller.reset
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case row :: column :: Nil => {
            controller.setCell(row, column)
          }
          case _ => println("False Input!!!")
        }
      }
    }
   continue
 }
}