package de.fhkoeln.reversi.model

import org.specs2.mutable._

class PlayboardSpec extends SpecificationWithJUnit {
  "A new Grid with the size of 1x1 and with no tokens in it " should {
    var board = new Playboard( 1 )
    
    "has not the size of 1x1" in {
      board.size must be_!= (1)
    }
    
    "becomes a size of 4x4" in {
      board.size must be_==(16)      
    }
    
    "must be multible of two" in {
      true must_== ( board.size % 2 == 0 )
    }
    
    "x , y must be the same size" in {
      board.x must be_==(board.y)
    }
    
    "should return an Emty cell at the coordinates x,y = 1,1" in {
      board.isFieldEmpty(1,1) must beTrue
    }
    
     "should return an Emty cell at the coordinates x,y = 1,2" in {
      board.isFieldEmpty(1,2) must beTrue
    }
     
    "should return an Emty cell at the coordinates x,y = 2,1" in {
      board.isFieldEmpty(2,1) must beTrue
    }
      
    "should return an empty token like '-' at the coords x,y = 1,1" in {
      var retChar: Char = board.getTokenFrom(1, 1)
      '-' must_== retChar
    }
    
    "should return an empty token like '-' at the coords x,y = 3,1" in {
      var retChar: Char = board.getTokenFrom(3,1)
      '-' must_== retChar
    }
       
    "should return a string like " +
    "+---+" + 
    "| - |" +
    "+---+" +
    " at the cords x,y = 1,1" in {
      board.getStringFrom( 1, 1 ) must be_==("+---+\n| - |\n+---+")
    }
    
    "should return a string like " +
    "+---+" + 
    "| - |" +
    "+---+" +
    " at the cords x,y = 2,4" in {
      board.getStringFrom( 2, 4 ) must be_==("+---+\n| - |\n+---+")     
    }
    
    /*"should return the Grid " in {
      var blocknum = 4                              
      val lineseparator: String = ("+---") * blocknum + "+\n" 
      val line: String = ("| - ") * blocknum + "|\n"        
      var box: String = "\n" + (lineseparator + (line)) * blocknum + lineseparator
      board.toString must be_== ( box )
    }   */  
  }
  
  "After an update with a white token at the coords 3,2 the field" should {
    var board = new Playboard( 1 )
    board.update( 3, 2, 'W' )
    
    "doesn't appears as an empty field" in {
      board.isFieldEmpty(3,2) must beFalse
    }
    
    "has a white token at the coords 3,2" in {
      var retChar: Char = board.getTokenFrom(3,2)
      'W' must_== retChar
    }
    
    "should return a string like " +
    "+---+" + 
    "| W |" +
    "+---+" +
    " at the cords x,y = 3,2" in {
      board.getStringFrom( 3, 2 ) must be_==("+---+\n| W |\n+---+")     
    }
  }
  
  "After another update whit a black token at the coords 2,3, the field" should {
    var board = new Playboard( 1 )
    board.update( 2, 3, 'B' )
    
    "doesn't appears as an empty field" in {
      board.isFieldEmpty(2,3) must beFalse
    }
    
    "has after an update a black token at the coords 2,3" in {
      var retChar: Char = board.getTokenFrom(2,3)
      'B' must_== retChar
    }
    
    "should return a string like " +
    "+---+" + 
    "| B |" +
    "+---+" +
    " at the cords x,y = 2,3" in {
      board.getStringFrom( 2, 3 ) must be_==("+---+\n| B |\n+---+")     
    } 
  }
}