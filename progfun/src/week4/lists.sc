
object lists {
  val x = List("x")                               //> x  : List[String] = List(x)
  val y = List("y")                               //> y  : List[String] = List(y)
  val zs = List("z", "s")                         //> zs  : List[String] = List(z, s)
  val xs = List("x", "s")                         //> xs  : List[String] = List(x, s)
  val ys = List("y", "s")                         //> ys  : List[String] = List(y, s)
  x :: y :: List(xs, ys) :: zs                    //> res0: List[Object] = List(List(x), List(y), List(List(x, s), List(y, s)), z,
                                                  //|  s)

  // insertion sort
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x >= y) x :: xs else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]
}