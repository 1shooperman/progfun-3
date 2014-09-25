//package week01

object session_ {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(130); 

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x);System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(96); 

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(guess * guess - x) / x < 0.001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(79); 

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2;System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(50); 

  def sqrt(x: Double): Double = sqrtIter(1.0, x);System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$0 = 
  
  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(14); val res$2 = 
  sqrt(0.001);System.out.println("""res2: Double = """ + $show(res$2));$skip(16); val res$3 = 
  sqrt(0.1e-20);System.out.println("""res3: Double = """ + $show(res$3));$skip(15); val res$4 = 
  sqrt(1.0e20);System.out.println("""res4: Double = """ + $show(res$4));$skip(15); val res$5 = 
  sqrt(1.0e50);System.out.println("""res5: Double = """ + $show(res$5))}
  
  

}
