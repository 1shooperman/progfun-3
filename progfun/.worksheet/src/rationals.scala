import math.abs

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  val x = new Rational(1, 3);System.out.println("""x  : Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(30); 

  val y = new Rational(5, 7);System.out.println("""y  : Rational = """ + $show(y ));$skip(8); val res$2 = 
  y + x;System.out.println("""res2: Rational = """ + $show(res$2));$skip(6); val res$3 = 

  -x;System.out.println("""res3: Rational = """ + $show(res$3));$skip(30); 

  val z = new Rational(3, 2);System.out.println("""z  : Rational = """ + $show(z ));$skip(13); val res$4 = 

  x - y - z;System.out.println("""res4: Rational = """ + $show(res$4));$skip(8); val res$5 = 
  y + y;System.out.println("""res5: Rational = """ + $show(res$5));$skip(8); val res$6 = 
  x < y;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(10); val res$7 = 
  x max y;System.out.println("""res7: Rational = """ + $show(res$7));$skip(86); val res$8 = 
  
  //val strange = new Rational(1, 0)
  //strange.add(strange)
  
  new Rational(2);System.out.println("""res8: Rational = """ + $show(res$8))}
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
