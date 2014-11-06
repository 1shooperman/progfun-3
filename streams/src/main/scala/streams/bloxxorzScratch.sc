package common

import streams.Bloxorz
import streams.GameDef
import streams.StringParserTerrain

object test {

  // Create a game
  val game = new StringParserTerrain {
//    val startPos = Pos(1,1)
//    val goal = Pos(5,5)
//    val terrain = ((p: Pos) => true)
    val level = Bloxorz.Level1.level
    
    val test = terrainFunction(Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o')))
    
    
    
    
    
    
    
    println(test(Pos(1,2)))
    
    println(findChar('T', Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'), Vector('T','T'))))
  }                                               //> true
                                                  //| Stream(Vector(S, T), ?)
                                                  //| Pos(0,1)
                                                  //| game  : streams.StringParserTerrain{val test: this.Pos => Boolean} = common.
                                                  //| test$$anonfun$main$1$$anon$1@498665a0
  //test
  // Now do stuff with it.
  game.Pos(2, 2).x                                //> res0: Int = 2

  // You can also use one of the predefined levels, such as this one
  Bloxorz.InfiniteLevel.startPos                  //> res1: streams.Bloxorz.InfiniteLevel.Pos = Pos(1,3)
  
  
  val someTest = Vector('a','b')                  //> someTest  : scala.collection.immutable.Vector[Char] = Vector(a, b)
  someTest.indexOf('c')                           //> res2: Int = -1
  
  
 
                                                  
                                                  
 
}