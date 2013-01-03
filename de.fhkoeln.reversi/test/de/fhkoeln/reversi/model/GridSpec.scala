package de.fhkoeln.reversi.model

import org.specs2.mutable._

class GridSpec extends SpecificationWithJUnit {
  "A new Grid with the size of 1x1 and with no tokens in it " should {
    val grid = new Grid( 1 )
    
    "has not the size of 1x1" in {
      grid.size must be_!= (1)
    }
    
    "becomes a size of 4x4" in {
      grid.size must be_==(4)      
    }
    
    "should return a string like " +
    "+---+" + 
    "|   |" +
    "+---+" in {
      grid.toString must be_==("+--+\n|   |\n+---+")
    }
    
  }
}