package de.fhkoeln.reversi.controller

import org.specs2.mutable._
import de.fhkoeln.reversi.model.Grid

class RevContSpec extends SpecificationWithJUnit {
  "When the Controller update the field at coords 5, 3 with a token and it's the white Players turn, " should {
    var grid: Grid = new Grid( 8 )
    var controller: ReversiController = new ReversiController( grid )
    controller.init
    var firstPlayersTurn: Boolean = controller.switchPlayer // false: first player, true: second player
    controller.setCell(5, 3)
    
    "then the field at that coords should appear as not empty." in {
      controller.isFieldEmpty( 5, 3 ) must be_!= ( true )
    }
    
    "then it's the next players turn." in {
      controller.switchPlayer must be_!= ( firstPlayersTurn )
    }
    
    "then the value of the token should be 'W'." in {
      var token: Char = controller.getTokenFrom(5, 3)
      'W' must_== token
    }
  }
  
  "After the first Player put a token down, the second Player put his token at the coords 6, 5 and " should {
    var grid: Grid = new Grid( 8 )
    var controller: ReversiController = new ReversiController( grid )
    controller.init
    var firstPlayersTurn: Boolean = controller.switchPlayer // false: first player, true: second player
    controller.setCell( 5, 3 )
    var secondPlayersTurn: Boolean = controller.switchPlayer
    controller.setCell( 6, 5 )
    
    "the field at that coords should appear as not empty." in {
      controller.isFieldEmpty( 6, 5 ) must be_!=( true )
    }
    
    "then it's the next players turn." in {
      controller.switchPlayer must be_!= ( secondPlayersTurn )
    }
    
    "the first player is on his turn." in {
      controller.switchPlayer must be_== ( firstPlayersTurn )
    }
    
    "then the value of the token should be 'B'." in {
      var token: Char = controller.getTokenFrom( 6, 5 ) 
      'B' must_== token
    }
  } 
  
  "When a field is not empty, " should {
    var grid: Grid = new Grid( 8 )
    var controller: ReversiController = new ReversiController( grid )
    controller.init
    
    "the white Player can't put his token in this field." in {
      controller.setCell( 4, 4 ) must be_!=( true )
    }
    
    "the black Player can't put his token in this field." in {
      controller.setCell( 4, 4 ) must be_!=( true )
    }
  }
  
  "After the playboard is init, the white Player put his token at the coords 5, 3 and" should {
    var grid: Grid = new Grid( 8 )
    var controller: ReversiController = new ReversiController( grid )
    controller.init
    
    "he is allowed to do so." in {
      controller.setCell( 4, 4 ) must be_!=( true )
    }
    
    "the field at the coords 5, 4 was updated to a white token." in {
      var token: Char = controller.getTokenFrom( 5, 4 )
      'W' must_== token
    }
  }
  
  "After the white Player put his token at the coords 5, 3, the black player put his at the coord's 6, 5 and" should {
    var grid: Grid = new Grid( 8 )
    var controller: ReversiController = new ReversiController( grid )
    controller.init
    
    "he is allowed to do so." in {
      controller.setCell( 4, 4 ) must be_!=( true )
    }
    
    "the field at the coords 5, 5 was updated to a white token." in {
      var token: Char = controller.getTokenFrom( 5, 5 )
      'W' must_== token
    }
  }
}