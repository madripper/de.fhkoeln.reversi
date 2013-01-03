package de.fhkoeln.reversi.model

import org.specs2.mutable._

class ClassSpec extends SpecificationWithJUnit  {
  "A new Cell at x,y=0,0 and with no tokens in it " should {
    val cell = new Cell( 0, 0, false, false )
    
    "has it's x-coords equal 0" in {
      cell.x must be_==(0)      
    }
    
    "has it's y-coords equal 0" in {
      cell.y must be_==(0)      
    }
    
    "appears as not set" in {
      cell.isSet must be_==(false)      
    }
    
    "appears not as set" in {
      cell.isSet must be_!=(true)      
    }
    
    "has no white token" in {
      cell.isWhite must be_==(false)      
    }
    
    "has a white token" in {
      cell.isWhite must be_!=(true)      
    }
    
    "has no black token" in {
      cell.isBlack must be_==(false)
    }
    
    "has a black token" in {
      cell.isBlack must be_!=(true)
    }
  }
  
  "A new Cell at x,y=3,7 and with a white token in it " should {
    val cell = new Cell( 3, 7, true, true )
    
    "has it's x-coords equal 3" in {
      cell.x must be_==(3)      
    }
    
    "has it's y-coords equal 7" in {
      cell.y must be_==(7)      
    }
    
    "doesn't appears to be set" in {
      cell.isSet must be_!=(false)      
    }
    
    "appears as set" in {
      cell.isSet must be_==(true)      
    }
    
    "has no white token" in {
      cell.isWhite must be_!=(false)      
    }
    
    "has a white token" in {
      cell.isWhite must be_==(true)      
    }
    
    "has no black token" in {
      cell.isBlack must be_==(false)
    }
    
    "has a black token" in {
      cell.isBlack must be_!=(true)
    }
  }
  
  "A new Cell at x,y=5,3 and with a black token in it " should {
    val cell = new Cell( 5, 3, true, false )
    
    "has it's x-coords equal 5" in {
      cell.x must be_==(5)      
    }
    
    "has it's y-coords equal 3" in {
      cell.y must be_==(3)      
    }
    
    "doesn't appears to be set" in {
      cell.isSet must be_!=(false)      
    }
    
    "appears as set" in {
      cell.isSet must be_==(true)      
    }
    
    "has no white token" in {
      cell.isWhite must be_==(false)      
    }
    
    "does not have a white token" in {
      cell.isWhite must be_!=(true)      
    }
    
    "has no black token" in {
      cell.isBlack must be_!=(false)
    }
    
    "has a black token" in {
      cell.isBlack must be_==(true)
    }
  }
  
  
}
