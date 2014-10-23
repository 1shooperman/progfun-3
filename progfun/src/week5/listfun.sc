package week5

object listfun {

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }                                               //> scaleList: (xs: List[Double], factor: Double)List[Double]

  def scaleListWithMap(xs: List[Double], factor: Double): List[Double] =
    xs map (x => x * factor)                      //> scaleListWithMap: (xs: List[Double], factor: Double)List[Double]

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]

  def squareListWithMap(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareListWithMap: (xs: List[Int])List[Int]

  def posElems(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)                        //> posElems: (xs: List[Int])List[Int]

  val fruits = List("apple", "pear", "banana")    //> fruits  : List[String] = List(apple, pear, banana)
  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)

  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))

  nums takeWhile (x => x > 0)                     //> res3: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  // should be List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
  pack(List("a", "a", "a", "b", "c", "c", "a"))   //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]

  // should be List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  encode(List("a", "a", "a", "b", "c", "c", "a")) //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))

  def sum(xs: List[Int]): Int = xs match {
    case Nil => 0
    case y :: ys => y + sum(ys)
  }                                               //> sum: (xs: List[Int])Int

  // reduceLeft puts a binary operator between adjacent
  // elements of a list
  def sum2(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y)
                                                  //> sum2: (xs: List[Int])Int
  def product(xs: List[Int]): Int = (1 :: xs) reduceLeft ((x, y) => x * y)
                                                  //> product: (xs: List[Int])Int
  def product2(xs: List[Int]): Int = (1 :: xs) reduceLeft (_ * _)
                                                  //> product2: (xs: List[Int])Int
  def sum3(xs: List[Int]): Int = (xs foldLeft 0)(_ + _)
                                                  //> sum3: (xs: List[Int])Int

  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys)(_ :: _)                     //> concat: [T](xs: List[T], ys: List[T])List[T]

  //    def concat2[T](xs: List[T], ys: List[T]): List[T] =
  //    (xs foldLeft ys) (_ :: _)

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)           //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, y) => y + 1)             //> lengthFun: [T](xs: List[T])Int
}