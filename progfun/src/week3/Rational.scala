package week3

class Rational(x: Int, y: Int) {
  require(y != 0, "denom must be nonzero")
  
  def this(x: Int) = this(x, 1)
  
  def abs(x: Int): Int = if (x < 0) -x else x

  private def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  private val g = gcd(x, y)
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

  def - (that: Rational) = this + -that
}