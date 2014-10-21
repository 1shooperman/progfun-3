object scratch2 {

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    xs match {
      case Nil => ys
      case x :: xs1 =>
        ys match {
          case Nil => xs
          case y :: ys1 =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
    }                                             //> merge: (xs: List[Int], ys: List[Int])List[Int]

  def merge2(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y::ys1) =>
      if (x < y) x :: merge2(xs1,ys)
      else y :: merge2(xs, ys1)
    }                                             //> merge2: (xs: List[Int], ys: List[Int])List[Int]

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (fst, snd) = xs splitAt n
      merge2(msort(fst), msort(snd))
    }
  }                                               //> msort: (xs: List[Int])List[Int]

  val pair = ("answer", 42)                       //> pair  : (String, Int) = (answer,42)

  val (label, value) = pair                       //> label  : String = answer
                                                  //| value  : Int = 42

  val label2 = pair._1                            //> label2  : String = answer
  val value2 = pair._2                            //> value2  : Int = 42
  
  val nums = List(2,-4,5,7,1)                     //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  msort(nums)                                     //> res0: List[Int] = List(-4, 1, 2, 5, 7)
}