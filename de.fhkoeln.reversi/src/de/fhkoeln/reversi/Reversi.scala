package de.fhkoeln.reversi

import de.fhkoeln.reversi.model.Grid
import de.fhkoeln.reversi.controller.ReversiController
import de.fhkoeln.reversi.view.tui.Tui

class Reversi {
  val controller = new ReversiController( new Grid( 8 )) // neuen Controller erzeugen mit einem 8x8-Feld
  val tui = new Tui( controller )	// neue Text-UI
  def main(args: Array[String]) {
    while (tui.processInputLine(readLine())) {}
  }
}