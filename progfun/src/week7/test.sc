package week7

object test {
  val problem = new Pouring(Vector(4, 7,19))      //> problem  : week7.Pouring = week7.Pouring@336e8a49
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.test.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), Fill(1
                                                  //| ), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Pour(2,1))
                                                  //| 
     
     
 // problem.pathSets.take(3).toList
 
 
  problem.solutions(6)                            //> res1: Stream[week7.test.problem.Path] = Stream(Fill(1) Pour(1,0) Pour(0,2) P
                                                  //| our(1,0) Fill(1) Pour(1,0)--> Vector(4, 6, 4), ?)
 
  
}