
object listfun2 {

}

//abstract class List[T] {
//  def reduceLeft(op: (T, T) => T): T = this match {
//    case Nil => throw new Error("bad")
//    case x :: xs => (xs foldLeft x)(op)
//  }
//  def foldLeft[U](z: U)(op: (U, T) => U): U = this match {
//    case Nil => z
//    case x :: xs => (xs foldLeft op(z, x))(op)
//  }
//def concat[T](xs: List[T], ys: List[T]): List[T] =
//    (xs foldRight ys) (_ :: _)
//}