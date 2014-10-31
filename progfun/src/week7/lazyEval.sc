object lazyEval {
  lazy val x = 2                                  //> x: => Int

  println(x)                                      //> 2

  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
  }                                               //> expr: => Int
  expr                                            //> xzyzres0: Int = 12

  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean

  ((1000 to 10000).toStream filter isPrime)(1)    //> res1: Int = 1013
  
  
  
}