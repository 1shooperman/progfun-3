package week6

object scratch {
  
  // 6.1
  
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Greetings Programs"                    //> s  : String = Greetings Programs
  s filter (c => c.isUpper)                       //> res1: String = GP
  
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  
  val t: Range = 1 to 5                           //> t  : Range = Range(1, 2, 3, 4, 5)
  
  
  1 to 10 by 3                                    //> res4: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  
  
  6 to 1 by -2                                    //> res5: scala.collection.immutable.Range = Range(6, 4, 2)
  
  val pairs = List(1,2,3) zip s                   //> pairs  : List[(Int, Char)] = List((1,G), (2,r), (3,e))
  pairs.unzip                                     //> res6: (List[Int], List[Char]) = (List(1, 2, 3),List(G, r, e))
  
  
  s flatMap (c => List('.', c))                   //> res7: String = .G.r.e.e.t.i.n.g.s. .P.r.o.g.r.a.m.s
  
  (1 to 3) flatMap (x => (1 to 2) map (y => (x,y)))
                                                  //> res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (2,1), (2,2), (3,1), (3,2))
  
 	def isPrime(n: Int): Boolean =
 	  (2 until n) forall (x => n % x != 0)    //> isPrime: (n: Int)Boolean
 	  
 	isPrime(5)                                //> res9: Boolean = true
 	isPrime(12)                               //> res10: Boolean = false
 	
 	
 	
 	
}