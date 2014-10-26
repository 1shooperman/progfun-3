
object scratch {

  type Occ = List[(Char, Int)]

  val xs1: Occ = List(('a', 2))                   //> xs1  : scratch.Occ = List((a,2))

  for {
    x <- xs1
    n <- 1 to x._2
  } yield List((x._1, n))                         //> res0: List[List[(Char, Int)]] = List(List((a,1)), List((a,2)))

  val xs2: Occ = List(('a', 2), ('b', 2))         //> xs2  : scratch.Occ = List((a,2), (b,2))
  val xs3 = for {
    x <- xs2
    n <- 1 to x._2
  } yield List((x._1, n))                         //> xs3  : List[List[(Char, Int)]] = List(List((a,1)), List((a,2)), List((b,1)),
                                                  //|  List((b,2)))

  val xs: Occ = List(('a', 2), ('b', 2))          //> xs  : scratch.Occ = List((a,2), (b,2))
  val xsSplit = xs.map(
    x => (for {
      n <- 1 to x._2
    } yield (x._1, n)).toList)                    //> xsSplit  : List[List[(Char, Int)]] = List(List((a,1), (a,2)), List((b,1), (b
                                                  //| ,2)))

  //val xsSplit =
  //  for {
  //    x <- xs
  //    n <- 1 to x._2
  //  } yield (x._1,n)

  
  
  
  
  def loop(xs: Occ): List[Occ] = {
    if (xs.isEmpty) List[Occ](List())
    else
     for {
       x <- loop(xs.tail)
       y <- xs
       n <- 1 to y._2
     } yield List((y._1,n)) ++ x
  }                                               //> loop: (xs: scratch.Occ)List[scratch.Occ]
  loop(xs)                                        //> res1: List[scratch.Occ] = List(List((a,1), (b,1)), List((a,2), (b,1)), List(
                                                  //| (b,1), (b,1)), List((b,2), (b,1)), List((a,1), (b,2)), List((a,2), (b,2)), L
                                                  //| ist((b,1), (b,2)), List((b,2), (b,2)))
    
    
    
    
    
    
}