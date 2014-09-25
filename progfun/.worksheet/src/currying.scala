
object currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(309); 
  //	def sum(f: Int => Int): (a: Int, b: Int) => Int = {
  //	    def sumF(a: Int, b: Int): Int = {
  //	      if (a > b) acc
  //	      else f(a) + sumF(a + 1, b)
  //	    }
  //	    sumF
  //	}

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(109); 

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(29); val res$0 = 

  product(x => x * x)(3, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(29); val res$1 = 

  product(x => x * x)(1, 5);System.out.println("""res1: Int = """ + $show(res$1));$skip(59); 

  def factorial(x: Int) = {
    product(x => x)(1, x)
  };System.out.println("""factorial: (x: Int)Int""");$skip(16); val res$2 = 

  factorial(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(178); 

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(97); 

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$3 = 

  product2(x => x * x)(3, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(30); val res$4 = 

  product2(x => x * x)(1, 5);System.out.println("""res4: Int = """ + $show(res$4))}
}
