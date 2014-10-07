package week4

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

object List {
  def apply[T]: List[T] = new Nil
  def apply[T](el: T): List[T] = new Cons(el, new Nil) 
  def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, new Nil))
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.head")
}