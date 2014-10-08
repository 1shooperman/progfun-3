package week4

// "idealized" boolean
abstract class iBoolean {
  def ifThenElse[T](t: => T, e: => T): T

  def &&(x: iBoolean): iBoolean = ifThenElse(x, iFalse)
  def ||(x: iBoolean): iBoolean = ifThenElse(iTrue, x)

  def unary_! = ifThenElse(iFalse, iTrue)

  def ==(x: iBoolean): iBoolean = ifThenElse(x, x.unary_!)
  def !=(x: iBoolean): iBoolean = ifThenElse(x.unary_!, x)
  
  def <(x: iBoolean): iBoolean = ifThenElse(iFalse, x)

}

object iTrue extends iBoolean {
  def ifThenElse[T](t: => T, e: => T) = t

}

object iFalse extends iBoolean {
  def ifThenElse[T](t: => T, e: => T) = e
}