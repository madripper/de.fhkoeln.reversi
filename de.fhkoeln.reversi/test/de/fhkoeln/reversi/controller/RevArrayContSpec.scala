package de.fhkoeln.reversi.controller

import org.specs2.mutable._
import de.fhkoeln.reversi.model.Playboard

class RevArrayContSpec extends SpecificationWithJUnit {
  "When the Controller update the field at coords 5, 3 with a token and it's the white Players turn, " should {
    var board: Playboard = new Playboard( 8 )
    var controller: ReversiArrayController = new ReversiArrayController( board )
    controller.init
    var firstPlayersTurn: Boolean = controller.switchPlayer // false: first player, true: second player
    controller.setCell(4, 2)
    
    "then the field at that coords should appear as not empty." in {
      controller.isFieldEmpty( 4, 2 ) must be_!= ( true )
    }
    
    "then it's the next players turn." in {
      controller.switchPlayer must be_!= ( firstPlayersTurn )
    }
    
    "then the value of the token should be 'W'." in {
      var token: Char = controller.getTokenFrom(4, 2)
      'W' must_== token
    }
  }
  
  "After the first Player put a token down, the second Player put his token at the coords 6, 5 and " should {
    var board: Playboard = new Playboard( 8 )
    var controller: ReversiArrayController = new ReversiArrayController( board )
    controller.init
    var firstPlayersTurn: Boolean = controller.switchPlayer // false: first player, true: second player
    controller.setCell( 4, 2 )
    var secondPlayersTurn: Boolean = controller.switchPlayer
    controller.setCell( 5, 4 )
    
    "the field at that coords should appear as not empty." in {
      controller.isFieldEmpty( 5, 4 ) must be_!=( true )
    }
    
    "then it's the next players turn." in {
      controller.switchPlayer must be_!= ( secondPlayersTurn )
    }
    
    "the first player is on his turn." in {
      controller.switchPlayer must be_== ( firstPlayersTurn )
    }
    
    "then the value of the token should be 'B'." in {
      var token: Char = controller.getTokenFrom( 5, 4 ) 
      'B' must_== token
    }
  } 
  
  "When a field is not empty, " should {
    var board: Playboard = new Playboard( 8 )
    var controller: ReversiArrayController = new ReversiArrayController( board )
    controller.init
    
    "the white Player can't put his token in this field." in {
      controller.setCell( 3, 3 ) must be_!=( true )
    }
    
    "the black Player can't put his token in this field." in {
      controller.setCell( 3, 3 ) must be_!=( true )
    }
  }
  
  "After the playboard is init, the white Player put his token at the coords 5, 3 and" should {
    var board: Playboard = new Playboard( 8 )
    var controller: ReversiArrayController = new ReversiArrayController( board )
    controller.init
    var isSuccessful: Boolean = controller.setCell( 4, 2 ) 
    
    "he is allowed to do so." in {
       isSuccessful must beTrue
    }
    
    "the field at this coords is not empty." in {
      controller.isFieldEmpty( 4, 2 ) must beFalse
    }
    
    "the field at this coords has a white token in it." in {
      var token: Char = controller.getTokenFrom( 4, 2 )
      'W' must_== token
    }   
    
    "the field at the coords 5, 4 was updated to a white token." in {
      var token: Char = controller.getTokenFrom( 4, 3 )
      'W' must_== token
    }
  }
  
  "After the white Player put his token at the coords 5, 3, the black player put his at the coord's 6, 5 and" should {
    var board: Playboard = new Playboard( 8 )
    var controller: ReversiArrayController = new ReversiArrayController( board )
    controller.init
    controller.setCell( 4, 2 )
    var isSuccessful: Boolean = controller.setCell( 5, 4 )
    
    "he is allowed to do so." in {
      isSuccessful must beTrue
    }
    
    "the field at this coords is not empty." in {
      controller.isFieldEmpty( 5, 4 ) must beFalse
    }
    
    "the field at this coords has a black token in it." in {
      var token: Char = controller.getTokenFrom( 5, 4 )
      'B' must_== token
    }  
    
    "the field at the coords 5, 5 was updated to a black token." in {
      var token: Char = controller.getTokenFrom( 4, 4 )
      'B' must_== token
    }
  }
  
  "After a few moves the user want's to reset the field. Now we expect " should {
    var board: Playboard = new Playboard( 8 )
    var controller: ReversiArrayController = new ReversiArrayController( board )
    controller.init
    controller.setCell( 4, 2 )//5, 3
    controller.setCell( 5, 4 )//6, 5
    
    controller.reset
    
    "after the reset no token at 5, 3" in {      
      board.isFieldEmpty(4, 2) must beTrue    
    } 
    
    "after the reset a black token at 5, 4" in {
      var token: Char = board.getTokenFrom(4, 3)
      'B' must_== token
    } 
    
    "after the reset a black token at 6, 5" in {
      board.isFieldEmpty(5, 4) must beTrue  
    } 
    
    "after the reset a white token at 5, 5" in {
      var token: Char = board.getTokenFrom(4, 4)
      'W' must_== token
    } 
    
    
  }
}