import math.abs

object rationals {
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3

  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  y + x                                           //> res2: Rational = 22/21

  -x                                              //> res3: Rational = -1/3

  val z = new Rational(3, 2)                      //> z  : Rational = 3/2

  x - y - z                                       //> res4: Rational = -79/42
  y + y                                           //> res5: Rational = 10/7
  x < y                                           //> res6: Boolean = true
  x max y                                         //> res7: Rational = 5/7
  
  //val strange = new Rational(1, 0)
  //strange.add(strange)
  
  new Rational(2)                                 //> res8: Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denom must be nonzero")
  
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  private val g = gcd(x, y)
//  def numer = x / g
//  def denom = y / g
  def numer = x
  def denom = y

  def + (that: Rational) = {
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  }

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  override def toString = (numer / g) + "/" + (denom / g )

  def unary_- = {
    new Rational(-numer, denom)
  }

  // def sub(that: Rational) = {
  //   new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  // }

  def - (that: Rational) = this + -that
}