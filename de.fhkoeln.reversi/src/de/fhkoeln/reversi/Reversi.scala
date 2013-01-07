package de.fhkoeln.reversi

import de.fhkoeln.reversi.model.Playboard
import de.fhkoeln.reversi.controller.ReversiArrayController
import de.fhkoeln.reversi.view.tui.Tui

object Reversi {
  val controller = new ReversiArrayController( new Playboard(8)) // neuen Controller erzeugen mit einem 8x8-Feld
  var tui = new Tui( controller )	// neue Text-UI
  def main(args: Array[String]) {
    while (tui.processInputLine(readLine())) {}
  }
}