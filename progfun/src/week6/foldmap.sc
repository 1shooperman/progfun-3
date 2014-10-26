
object foldmap {
  val x: List[Int] = List(1,2,3)                  //> x  : List[Int] = List(1, 2, 3)
  
  x.foldLeft(0)((x,y) => x + y)                   //> res0: Int = 6
  
  x.foldRight(0)((x,y) => x + y)                  //> res1: Int = 6
  
  
  
  x.foldLeft(0)((x,y) => {
   println("x " + x)
    println("y " + y)
    println("x+y " + (x + y))
    x + y
  })                                              //> x 0
                                                  //| y 1
                                                  //| x+y 1
                                                  //| x 1
                                                  //| y 2
                                                  //| x+y 3
                                                  //| x 3
                                                  //| y 3
                                                  //| x+y 6
                                                  //| res2: Int = 6
  
  
  x.foldRight(0)((x,y) => {
   println("x " + x)
    println("y " + y)
    println("x+y " + (x + y))
    x + y
  })                                              //> x 3
                                                  //| y 0
                                                  //| x+y 3
                                                  //| x 2
                                                  //| y 3
                                                  //| x+y 5
                                                  //| x 1
                                                  //| y 5
                                                  //| x+y 6
                                                  //| res3: Int = 6
  for {
    i <- x
    n <- 2 to 1 by -1
  } yield {
    println("xElem " + i)
    println("n " + n)
  }                                               //> xElem 1
                                                  //| n 2
                                                  //| xElem 1
                                                  //| n 1
                                                  //| xElem 2
                                                  //| n 2
                                                  //| xElem 2
                                                  //| n 1
                                                  //| xElem 3
                                                  //| n 2
                                                  //| xElem 3
                                                  //| n 1
                                                  //| res4: List[Unit] = List((), (), (), (), (), ())
  
  
  val y = List(('a',2),('b',2))                   //> y  : List[(Char, Int)] = List((a,2), (b,2))
  for {
    pair <- y
    n <- 1 to pair._2
  } yield {
    println("pair " + pair)
    println("n " + n)
    println("(" + pair._1 + "," + n + ")")
    
    (pair._1, n)
  }                                               //> pair (a,2)
                                                  //| n 1
                                                  //| (a,1)
                                                  //| pair (a,2)
                                                  //| n 2
                                                  //| (a,2)
                                                  //| pair (b,2)
                                                  //| n 1
                                                  //| (b,1)
                                                  //| pair (b,2)
                                                  //| n 2
                                                  //| (b,2)
                                                  //| res5: List[(Char, Int)] = List((a,1), (a,2), (b,1), (b,2))
  y.foldRight(List(List()): List[List[(Char,Int)]])(
      (x, y) => {
      println("y " + y)
      println("x " + x)
      y ++ (for {
        a <- y
        n <- 1 to x._2
      } yield {
        println("a " + a)
        println("n " + n)
        println("pair (" + x._1 + "," + n + ")")
        (x._1, n)
      } :: a)
      
      }
      )                                           //> y List(List())
                                                  //| x (b,2)
                                                  //| a List()
                                                  //| n 1
                                                  //| pair (b,1)
                                                  //| a List()
                                                  //| n 2
                                                  //| pair (b,2)
                                                  //| y List(List(), List((b,1)), List((b,2)))
                                                  //| x (a,2)
                                                  //| a List()
                                                  //| n 1
                                                  //| pair (a,1)
                                                  //| a List()
                                                  //| n 2
                                                  //| pair (a,2)
                                                  //| a List((b,1))
                                                  //| n 1
                                                  //| pair (a,1)
                                                  //| a List((b,1))
                                                  //| n 2
                                                  //| pair (a,2)
                                                  //| a List((b,2))
                                                  //| n 1
                                                  //| pair (a,1)
                                                  //| a List((b,2))
                                                  //| n 2
                                                  //| pair (a,2)
                                                  //| res6: List[List[(Char, Int)]] = List(List(), List((b,1)), List((b,2)), List
                                                  //| ((a,1)), List((a,2)), List((a,1), (b,1)), List((a,2), (b,1)), List((a,1), (
                                                  //| b,2)), List((a,2), (b,2)))
}