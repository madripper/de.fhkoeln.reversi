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
    
    "returns the String ' '." in {
      cell.toString must be_==( " " )
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
    
    "doesn't return ' '." in {
      cell.toString must be_!=( " " )
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
    
    "doesn't return ' '." in {
      cell.toString must be_!=( " " )
    }
  }
}
