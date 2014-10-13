package week4

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

object List {
  def apply[T]: List[T] = Nil
  def apply[T](el: T): List[T] = new Cons(el, Nil) 
  def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, Nil))
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.head")
}

object test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}