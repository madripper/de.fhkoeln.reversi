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
      board.isFieldEmpty(0,0) must beTrue
    }
    
     "should return an Emty cell at the coordinates x,y = 1,2" in {
      board.isFieldEmpty(0,1) must beTrue
    }
     
    "should return an Emty cell at the coordinates x,y = 2,1" in {
      board.isFieldEmpty(1,0) must beTrue
    }
      
    "should return an empty token like '-' at the coords x,y = 1,1" in {
      var retChar: Char = board.getTokenFrom(0, 0)
      '-' must_== retChar
    }
    
    "should return an empty token like '-' at the coords x,y = 3,1" in {
      var retChar: Char = board.getTokenFrom(2,0)
      '-' must_== retChar
    }
       
    "should return a string like " +
    "+---+" + 
    "| - |" +
    "+---+" +
    " at the cords x,y = 1,1" in {
      board.getStringFrom( 0, 0 ) must be_==("+---+\n| - |\n+---+")
    }
    
    "should return a string like " +
    "+---+" + 
    "| - |" +
    "+---+" +
    " at the cords x,y = 2,4" in {
      board.getStringFrom( 1, 3 ) must be_==("+---+\n| - |\n+---+")     
    }
  }
  
  "After an update with a white token at the coords 3,2 the field" should {
    var board = new Playboard( 1 )
    board.update( 2, 1, 'W' )
    
    "doesn't appears as an empty field" in {
      board.isFieldEmpty(2,1) must beFalse
    }
    
    "has a white token at the coords 3,2" in {
      var retChar: Char = board.getTokenFrom(2,1)
      'W' must_== retChar
    }
    
    "should return a string like " +
    "+---+" + 
    "| W |" +
    "+---+" +
    " at the cords x,y = 3,2" in {
      board.getStringFrom( 2, 1 ) must be_==("+---+\n| W |\n+---+")     
    }
  }
  
  "After another update whit a black token at the coords 2,3, the field" should {
    var board = new Playboard( 1 )
    board.update( 1, 2, 'B' )
    
    "doesn't appears as an empty field" in {
      board.isFieldEmpty(1,2) must beFalse
    }
    
    "has after an update a black token at the coords 2,3" in {
      var retChar: Char = board.getTokenFrom(1,2)
      'B' must_== retChar
    }
    
    "should return a string like " +
    "+---+" + 
    "| B |" +
    "+---+" +
    " at the cords x,y = 2,3" in {
      board.getStringFrom( 1, 2 ) must be_==("+---+\n| B |\n+---+")     
    } 
  }
  
  "After the init from the Playboard, " should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    
    "the Cell at 4, 4 has a white Token." in {
      var token: Char = board.getTokenFrom( 3, 3)
      'W' must_== token
    }
    
    "the Cell at 5, 4 has a black Token." in {
      var token: Char = board.getTokenFrom( 4, 3)
      'B' must_== token
    }
    
    "the Cell at 5, 5 has a white Token." in {
      var token: Char = board.getTokenFrom( 4, 4)
      'W' must_== token
    }
    
    "the Cell at 4, 5 has a black Token." in {
      var token: Char = board.getTokenFrom( 3, 4)
      'B' must_== token
    }
    
    "the white Player tries to put a token at coords 5, 3 and we didn't find another white token at 5, 2" in {
      var isToken: Boolean = board.findMove( 4, 2, 6, false )
      true must_!= isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we didn't find another white token at 6, 2" in {
      var isToken: Boolean = board.findMove( 4, 2, 2, false )
      true must_!= isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we didn't find another white token at 6, 3" in {
      var isToken: Boolean = board.findMove( 4, 2, 7, false )
      true must_!= isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we didn't find another white token at 6, 4" in {
      var isToken: Boolean = board.findMove( 4, 2, 3, false )
      true must_!= isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we find another white token at 5, 5" in {
      var isToken: Boolean = board.findMove( 4, 2, 8, false )
      true must_== isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we find another white token at 4, 4" in {
      var isToken: Boolean = board.findMove( 4, 2, 4, false )
      true must_== isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we didn't find another white token at 4, 3" in {
      var isToken: Boolean = board.findMove( 4, 2, 5, false )
      true must_!= isToken
    }
    "the white Player tries to put a token at coords 5, 3 and we didn't find another white token at 4, 2" in {
      var isToken: Boolean = board.findMove( 4, 2, 1, false )
      true must_!= isToken
    }
    
    "the white Player tries to put a token at coords 5, 3 and one possible move is to coords 5, 5." in {
      board.possibleMove(4, 2, false).contains((4, 2, 8)) must beTrue
    }
    
    "the white Player tries to put a token at coords 5, 3 and one possible move is to coords 4, 4." in {
      board.possibleMove(4, 2, false).contains((4, 2, 4)) must beTrue
    }
    
    "the white Player tries an invalid move at the coords -2, -4." in {
      board.findMove(-3, -5, 5, false) must beFalse      
    }
    
    "the white Player tries an invalid move in a wrong direction." in {
      board.findMove(7, 7, 10, false) must beFalse      
    }
  }
  
  "After the init from the Playboard and after the white Player put his token at coords 4, 4, " should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'W' )
    board.update( 3, 4, 'B' )
    board.update( 4, 2, 'W' )
        
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 6, 4" in {
      var isToken: Boolean = board.findMove( 5, 4, 6, true )
      true must_!= isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 7, 4" in {
      var isToken: Boolean = board.findMove( 5, 4, 2, true )
      true must_!= isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 7, 5" in {
      var isToken: Boolean = board.findMove( 5, 4, 7, true )
      true must_!= isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 7, 6" in {
      var isToken: Boolean = board.findMove( 5, 4, 3, true )
      true must_!= isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 6, 6" in {
      var isToken: Boolean = board.findMove( 5, 4, 8, true )
      true must_!= isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 5, 6" in {
      var isToken: Boolean = board.findMove( 5, 4, 4, true )
      true must_!= isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we find another black token at 4, 5" in {
      var isToken: Boolean = board.findMove( 5, 4, 5, true )
      true must_== isToken
    }
    "the black Player tries to put a token at coords 6, 5 and we didn't find another black token at 5, 4" in {
      var isToken: Boolean = board.findMove( 5, 4, 1, true )
      true must_!= isToken
    }
    
    "the black Player tries to put a token at coords 6, 5 and one possible move is to coords 4, 5." in {
      board.possibleMove(5, 4, true).contains((5, 4, 5)) must beTrue
    }    
    
    "the black Player tries an invalid move at the coords 22, 4." in {
      board.findMove(21, 4, 1, false) must beFalse      
    }
    
    "the black Player tries an invalid move in a wrong direction." in {
      board.findMove(7, 7, -5, false) must beFalse      
    }
  }
  
  "After the default init, the white player put a token at the coords 3, 3." should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    board.takeTurn( 2, 2, false, 1 )
    
    "The field at this coords is empty, because this move is not allowed." in {
      board.isFieldEmpty(2, 2) must beTrue      
    }
        
    "White takes another token at the coords 5,3 and the black token at 5,4 turns to a white token." in {
      board.takeTurn( 4, 2, false, 8 )
      var token: Char = board.getTokenFrom(4, 3)
      'W' must_== token
    }
  }
  
  "After the default init, the black player put a token at the coords 6, 2." should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    board.takeTurn( 5, 1, true, 1 )
    
    "The field at this coords is empty, because this move is not allowed." in {
      board.isFieldEmpty(5, 1) must beTrue      
    }
    
    "Black takes another token at the coords 6,5 and the white token at 5,5 turns to a black token." in {
      board.takeTurn( 5, 4, true, 5 )
      var token: Char = board.getTokenFrom(4, 4)
      'B' must_== token
    }
  }
  
  "After the default init, " should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    
    "the white Player has 14 possible moves." in {
      board.possibleMoves( false ).size must be_== ( 14 )
    }
    
    "the black Player has 14 possible moves." in {
      board.possibleMoves( true ).size must be_== ( 14 )
    }
  } 
  
  "For an up-right check, the board will be initialized and the white player put a token at 3,5, " should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    board.takeTurn(2, 4, false, 7 )
    
    "at 3, 5 is a white token." in {
      var token: Char = board.getTokenFrom(2, 4)
      'W' must_== token
    }
    
    "at 4,5 is a white token." in {
      var token: Char = board.getTokenFrom(3, 4)
      'W' must_== token
    }
  }
  
  "Directionalcheck after a few turns. There should be " should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    board.takeTurn(2, 4, false, 7 )// 3, 5
    board.takeTurn(2, 5, true, 2 ) // 3, 6  
    board.takeTurn(5, 3, false, 5 )// 6, 4
    board.takeTurn(5, 2, true, 4 ) // 6, 3  
    board.takeTurn(3, 5, false, 6 )// 4, 6
    board.takeTurn(2, 3, true, 7 ) // 3, 4
    board.takeTurn(2, 3, true, 8 ) // 3, 4
    board.takeTurn(2, 2, false, 3 )// 3, 3
    
    "a white token at 3, 3." in {
      var token: Char = board.getTokenFrom(2, 2)
      'W' must_== token
    }
    
    "a black token at 6, 3." in {
      var token: Char = board.getTokenFrom(5, 2)
      'B' must_== token
    }
    
    "a black token at 3, 4." in {
      var token: Char = board.getTokenFrom(2, 3)
      'B' must_== token
    }
    
    "a white token at 4, 4." in {
      var token: Char = board.getTokenFrom(3, 3)
      'W' must_== token
    }
    
    "a black token at 5, 4." in {
      var token: Char = board.getTokenFrom(4, 3)
      'B' must_== token
    }
    
    "a white token at 6, 4." in {
      var token: Char = board.getTokenFrom(5, 3)
      'W' must_== token
    }
    
    "a black token at 3, 5." in {
      var token: Char = board.getTokenFrom(2, 4)
      'B' must_== token
    }
    
    "a white token at 4, 5." in {
      var token: Char = board.getTokenFrom(3, 4)
      'W' must_== token
    }
    
    "a white token at 5, 5." in {
      var token: Char = board.getTokenFrom(4, 4)
      'W' must_== token
    }
    
    "a black token at 3, 6." in {
      var token: Char = board.getTokenFrom(2, 5)
      'B' must_== token
    }
    
    "a white token at 4, 6." in {
      var token: Char = board.getTokenFrom(3, 5)
      'W' must_== token
    }    
    
    var isSuccessful: Boolean = board.takeTurn(7, 7, false, 15)
    "a wrong move, which isn't successful." in {
      isSuccessful must beFalse
    }
  }
  
  "After a few rounds, the board will be reset and " should {
    var board = new Playboard( 8 )
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    board.takeTurn(2, 4, false, 7 )// 3, 5
    board.takeTurn(2, 5, true, 2 ) // 3, 6  
    board.takeTurn(5, 3, false, 5 )// 6, 4
    board.takeTurn(5, 2, true, 4 ) // 6, 3  
    board.takeTurn(3, 5, false, 6 )// 4, 6
    board.takeTurn(2, 3, true, 7 ) // 3, 4
    board.takeTurn(2, 3, true, 8 ) // 3, 4
    board.takeTurn(2, 2, false, 3 )// 3, 3
    
    /**
     * Testfälle werden nicht immer in gleicher Reihenfolge durchgeführt.
     * Dadurch wird dieser Testfall mal vor, mal nach dem Reset  des Boards
     * ausgeführt und ist somit unbrauchbar.
    "a token is at 6, 4 before the reset" in {
      board.isFieldEmpty(5, 3) must beFalse
    }  
    */
    board.reset
    board.update( 3, 3, 'W' )
    board.update( 4, 4, 'W' )
    board.update( 4, 3, 'B' )
    board.update( 3, 4, 'B' )
    
    "a white token is at 4,4." in {
      var token: Char = board.getTokenFrom(3, 3)
      'W' must_== token
    }
    
    "a black token is at 5,4." in {
      var token: Char = board.getTokenFrom(4, 3)
      'B' must_== token
    }
    
    "a black token is at 4,5." in {
      var token: Char = board.getTokenFrom(3, 4)
      'B' must_== token
    }
    
    "a white token is at 5,5." in {
      var token: Char = board.getTokenFrom(4, 4)
      'W' must_== token
    }
    
    "no token at 6, 4" in {
      board.isFieldEmpty(5, 3) must beTrue
    }    
  }
  
}