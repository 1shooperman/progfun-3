
object listcomb {
  val xs = List(List('a', 'b'), List('c', 'd'))   //> xs  : List[List[Char]] = List(List(a, b), List(c, d))

  xs.foldRight(List(): List[Any])((x, y) => y ++ (List(x) ::: y))
                                                  //> res0: List[Any] = List(List(c, d), List(a, b), List(c, d))

  xs.foldLeft(List(): List[Any])((x, y) => y ++ (List(x) ::: y))
                                                  //> res1: List[Any] = List(c, d, List(a, b, List(), a, b), c, d)

  xs.foldRight(List(): List[Any])((x, y) => y ++ (x :: y))
                                                  //> res2: List[Any] = List(List(c, d), List(a, b), List(c, d))

  xs.foldLeft(List(): List[Any])((x, y) => y ++ (x :: y))
                                                  //> res3: List[Any] = List(c, d, List(a, b, List(), a, b), c, d)

  xs.foldRight(List(): List[Any])((x, y) => y ++ List(x))
                                                  //> res4: List[Any] = List(List(c, d), List(a, b))

  xs.foldLeft(List(): List[Any])((x, y) => y ++ List(x))
                                                  //> res5: List[Any] = List(c, d, List(a, b, List()))

  (for {
    x <- xs
  } yield x :: xs)                                //> res6: List[List[List[Char]]] = List(List(List(a, b), List(a, b), List(c, d))
                                                  //| , List(List(c, d), List(a, b), List(c, d)))

  def loop(xs: List[List[Char]]): List[List[Char]] = {
    for {
      x <- xs
    } yield x
  }                                               //> loop: (xs: List[List[Char]])List[List[Char]]
  loop(xs)                                        //> res7: List[List[Char]] = List(List(a, b), List(c, d))

  xs.foldLeft(List(): List[Any])(
    (x, y) => y ++ (for {
      x <- xs
    } yield y.flatMap((z) => if (!x.contains(z)) (z :: x) else x)).map(w => w.distinct))
                                                  //> res8: List[Any] = List(c, d, List(c, a, b, d), List(c, d))

  val xs2 = List(List(('a', 2), ('a', 1)), List(('b', 2), ('b', 1)))
                                                  //> xs2  : List[List[(Char, Int)]] = List(List((a,2), (a,1)), List((b,2), (b,1))
                                                  //| )
  val p = List()                                  //> p  : List[Nothing] = List()

  for {
    x <- xs2
  } yield x                                       //> res9: List[List[(Char, Int)]] = List(List((a,2), (a,1)), List((b,2), (b,1)))
                                                  //| 

  xs2.map(
    x => (for {
      y <- x
    } yield y))                                   //> res10: List[List[(Char, Int)]] = List(List((a,2), (a,1)), List((b,2), (b,1))
                                                  //| )

  for {
    q <- Set(List())
    c <- 0 to 2
  } yield c :: q                                  //> res11: scala.collection.immutable.Set[List[Int]] = Set(List(0), List(1), Lis
                                                  //| t(2))

  val x = for {
    q <- Set(List(0), List(1), List(2))
    c <- 0 to 2
  } yield c :: q                                  //> x  : scala.collection.immutable.Set[List[Int]] = Set(List(1, 1), List(1, 2)
                                                  //| , List(2, 1), List(2, 2), List(2, 0), List(0, 2), List(0, 1), List(0, 0), L
                                                  //| ist(1, 0))
  val y = for {
    q <- x
    c <- 0 to 2
  } yield c :: q                                  //> y  : scala.collection.immutable.Set[List[Int]] = Set(List(2, 1, 2), List(2,
                                                  //|  2, 2), List(2, 0, 1), List(1, 0, 1), List(0, 0, 2), List(0, 0, 0), List(1,
                                                  //|  2, 0), List(0, 1, 0), List(0, 1, 1), List(2, 1, 0), List(0, 1, 2), List(2,
                                                  //|  2, 1), List(2, 2, 0), List(0, 0, 1), List(1, 0, 0), List(0, 2, 0), List(1,
                                                  //|  1, 2), List(1, 1, 1), List(1, 2, 1), List(2, 1, 1), List(2, 0, 2), List(0,
                                                  //|  2, 1), List(1, 2, 2), List(2, 0, 0), List(0, 2, 2), List(1, 0, 2), List(1,
                                                  //|  1, 0))
  y.size                                          //> res12: Int = 27

  val cc = List(('a', 2), ('b', 2))               //> cc  : List[(Char, Int)] = List((a,2), (b,2))
  def combos(c2: List[(Char, Int)]): List[List[(Char, Int)]] = {
    if (c2.isEmpty) List(List())
    else
      for {
        x <- combos(c2.tail)
        n <- 1 to 2
      } yield ('h', n) :: x
  }                                               //> combos: (c2: List[(Char, Int)])List[List[(Char, Int)]]
  combos(cc)                                      //> res13: List[List[(Char, Int)]] = List(List((h,1), (h,1)), List((h,2), (h,1)
                                                  //| ), List((h,1), (h,2)), List((h,2), (h,2)))

  cc.tail                                         //> res14: List[(Char, Int)] = List((b,2))

  // given cc = List(('a',2),('b',2))
  //  def combos2(c2: (Char,Int)): List[(Char,Int)] = {
  //    for {
  //      x <- cc
  //    } yield
  //  }
  //  cc.map(
  //   x => combos2(x)
  //  )

  //given cc = List(('a',2),('b',2))
  //given xs2

//  def bbbb(xs: List[(Char,Int)]): List[List[(Char,Int)]] = {
//    for {
//      x <- bbbb(xs)
//    }
  
//    for {
//      x <- bbbb(cc)
//      n <- 1 to x._2
//    } yield (x._1, n) :: List(())
//  }
//  bbbb(cc)

cc.map( tupl =>
for {
  x <- cc
  n <- 1 to x._2
} yield (x._1,n) :: List(())
       )                                          //> res15: List[List[List[Any]]] = List(List(List((a,1), ()), List((a,2), ()), 
                                                  //| List((b,1), ()), List((b,2), ())), List(List((a,1), ()), List((a,2), ()), L
                                                  //| ist((b,1), ()), List((b,2), ())))
       
       
       
val btest = List(
  List(('a',1),('a',2)),
  List(('b',1),('b',2)),
  List(('c',1),('c',2))
)                                                 //> btest  : List[List[(Char, Int)]] = List(List((a,1), (a,2)), List((b,1), (b,
                                                  //| 2)), List((c,1), (c,2)))
val btest2 = List(('a',2),('b',2),('c',3))        //> btest2  : List[(Char, Int)] = List((a,2), (b,2), (c,3))


type Occ = List[(Char, Int)]

cc.foldRight(List(List()): List[Occ])(
 (x,y) => y ++ (for {
   a <- y
   n <- 1 to x._2
 } yield (x._1, n) :: a))                         //> res16: List[listcomb.Occ] = List(List(), List((b,1)), List((b,2)), List((a,
                                                  //| 1)), List((a,2)), List((a,1), (b,1)), List((a,2), (b,1)), List((a,1), (b,2)
                                                  //| ), List((a,2), (b,2)))
 
//def loop1(p: List[(Char, Int)]) : List[(Char, Int)] = {
// if (p.isEmpty) List()
// else
//   for {
//     x <- p.map(x => )
//     n <- 1 to x._2
//   } yield (x._1,n) :: loop1(p.tail)
//}
//loop1(btest2)





       
}