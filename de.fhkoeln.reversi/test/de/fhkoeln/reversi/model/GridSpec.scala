package de.fhkoeln.reversi.model

import org.specs2.mutable._

class GridSpec extends SpecificationWithJUnit {
  "A new Grid with the size of 1x1 and with no tokens in it " should {
    var cell = new Cell( '-' )
    var grid = new Grid( Vector( cell ) )
    
    "has not the size of 1x1" in {
      grid.size must be_!= (1)
    }
    
    "becomes a size of 4x4" in {
      grid.size must be_==(16)      
    }
    
    "must be multible of two" in {
      true must_== ( grid.size % 2 == 0 )
    }
    
    "x , y must be the same size" in {
      grid.x must be_==(grid.y)
    }
    
    "should return an Emty cell at the coordinates x,y = 1,1" in {
      grid.isFieldEmpty(1,1) must beTrue
    }
    
     "should return an Emty cell at the coordinates x,y = 1,2" in {
      grid.isFieldEmpty(1,2) must beTrue
    }
     
    "should return an Emty cell at the coordinates x,y = 2,1" in {
      grid.isFieldEmpty(2,1) must beTrue
    }
      
    "should return an empty token like '-' at the coords x,y = 1,1" in {
      var retChar: Char = grid.getTokenFrom(1, 1)
      '-' must_== retChar
    }
    
    "should return an empty token like '-' at the coords x,y = 3,1" in {
      var retChar: Char = grid.getTokenFrom(3,1)
      '-' must_== retChar
    }
       
    "should return a string like " +
    "+---+" + 
    "| - |" +
    "+---+" +
    " at the cords x,y = 1,1" in {
      grid.getStringFrom( 1, 1 ) must be_==("+---+\n| - |\n+---+")
    }
    
    "should return a string like " +
    "+---+" + 
    "| - |" +
    "+---+" +
    " at the cords x,y = 2,4" in {
      grid.getStringFrom( 2, 4 ) must be_==("+---+\n| - |\n+---+")     
    }
    
    "should return the Grid " in {
      var blocknum = 4                              
      val lineseparator: String = ("+---") * blocknum + "+\n" 
      val line: String = ("| - ") * blocknum + "|\n"        
      var box: String = "\n" + (lineseparator + (line)) * blocknum + lineseparator
      grid.toString must be_== ( box )
    } 
    
    grid.update( 3, 2, 'W' )
    "appears no longer as empty after an update with a white token at the coords 3,2" in {
      grid.isFieldEmpty(3,2) must beFalse
    }
    
    "has after an update a white token at the coords 3,2" in {
      var retChar: Char = grid.getTokenFrom(3,2)
      'W' must_== retChar
    }
    
    "should return a string like " +
    "+---+" + 
    "| W |" +
    "+---+" +
    " at the cords x,y = 3,2" in {
      grid.getStringFrom( 3, 2 ) must be_==("+---+\n| W |\n+---+")     
    }
    
    grid.update( 2, 3, 'B' )
    "appears no longer as empty after an update with a black token at the coords 2,3" in {
      grid.isFieldEmpty(2,3) must beFalse
    }
    
    "has after an update a black token at the coords 2,3" in {
      var retChar: Char = grid.getTokenFrom(2,3)
      'B' must_== retChar
    }
    
    "should return a string like " +
    "+---+" + 
    "| B |" +
    "+---+" +
    " at the cords x,y = 2,3" in {
      grid.getStringFrom( 2, 3 ) must be_==("+---+\n| B |\n+---+")     
    }
    
    
  }
}