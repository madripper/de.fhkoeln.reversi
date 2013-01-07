package de.fhkoeln.reversi.model

import org.specs2.mutable._

class CellSpec extends SpecificationWithJUnit  {
  "A new Cell with no tokens" should {
    val cell = new Cell( '-' );
    
    "appears as empty." in {
      cell.isEmpty must be_==( true )
    }
    
    "has no white token in it." in {
      val data: Char = cell.token
      'W' must_!= data
    }
    
    "has no black token in it." in {
      val data: Char = cell.token
      'B' must_!= data
    }
    
    "returns the String '-'." in {
      cell.toString must be_==( "-" )
    }
    
    "doesn't return 'W'." in {
      cell.toString must be_!=( "W" )
    }
    
    "doesn't return 'B'." in {
      cell.toString must be_!=( "B" )
    }
  }
  
  "A new Cell with a white token in it" should {
    val cell = new Cell( 'W' );
    
    "appears not as empty." in {
      cell.isEmpty must be_!=( true )
    }
    
    "has a white token in it." in {
      val data: Char = cell.token
      'W' must_== data
    }
    
    "has no black token in it." in {
      val data: Char = cell.token
      'B' must_!= data
    }
    
    "returns the String 'W'." in {
      cell.toString must be_==( "W" )
    }
    
    "doesn't return '-'." in {
      cell.toString must be_!=( "-" )
    }
    
    "doesn't return 'B'." in {
      cell.toString must be_!=( "B" )
    }
  }
  
  "A new Cell with a black token in it" should {
    val cell = new Cell( 'B' );
    
    "appears not as empty." in {
      cell.isEmpty must be_!=( true )
    }
    
    "has no white token in it." in {
      val data: Char = cell.token
      'W' must_!= data
    }
    
    "has a black token in it." in {
      val data: Char = cell.token
      'B' must_== data
    }
    
    "returns the String 'B'." in {
      cell.toString must be_==( "B" )
    }
    
    "doesn't return 'W'." in {
      cell.toString must be_!=( "W" )
    }
    
    "doesn't return '-'." in {
      cell.toString must be_!=( "-" )
    }
  }
  
  "An empty Cell has after an Update to a white token" should {
    val cell = new Cell( '-' )
    cell.update( 'W' )
    "appears not as empty" in {
      cell.isEmpty must be_!=( true )
    }
    
    "has a white token in it" in {
      val data: Char = cell.token
      'W' must_== data
    }
    
    "returns the string 'W'" in {
      cell.toString must be_==( "W" )
    }
  }
  
  "An empty Cell has after an Update to a white token" should {
    val cell = new Cell( '-' )
    cell.update( 'B' )
    "appears not as empty" in {
      cell.isEmpty must be_!=( true )
    }
    
    "has a white token in it" in {
      val data: Char = cell.token
      'B' must_== data
    }
    
    "returns the string 'B'" in {
      cell.toString must be_==( "B" )
    }
  }
  
  "An Cell with no valid Tokens in it, which catched by the default Case," should {
    val cell = new Cell( ' ' )
    "will be empty." in {
      cell.isEmpty must beTrue
    }
    
    "has no token in it." in {
      var token: Char = cell.token
      '-' must_== token
    }
    
    "returns the string '-'." in {
      var token: Char = cell.token
      '-' must_== token
    }
    
    
    
    
  }
}
