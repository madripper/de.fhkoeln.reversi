package de.fhkoeln.reversi

import de.fhkoeln.reversi.model.Grid
import de.fhkoeln.reversi.controller.ReversiController
import de.fhkoeln.reversi.view.tui.Tui

class Reversi {
  var cell = new Cell( '-' )
  var controller = new ReversiController( new Grid( Vector(  ) )) // neuen Controller erzeugen mit einem 8x8-Feld
  var tui = new Tui( controller )	// neue Text-UI
  def main(args: Array[String]) {
    while (tui.processInputLine(readLine())) {}
  }
}