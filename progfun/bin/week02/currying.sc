
object currying {
  //	def sum(f: Int => Int): (a: Int, b: Int) => Int = {
  //	    def sumF(a: Int, b: Int): Int = {
  //	      if (a > b) acc
  //	      else f(a) + sumF(a + 1, b)
  //	    }
  //	    sumF
  //	}

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)     //> sum: (f: Int => Int)(a: Int, b: Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 4)                       //> res0: Int = 144

  product(x => x * x)(1, 5)                       //> res1: Int = 14400

  def factorial(x: Int) = {
    product(x => x)(1, x)
  }                                               //> factorial: (x: Int)Int

  factorial(5)                                    //> res2: Int = 120

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b)        //> product2: (f: Int => Int)(a: Int, b: Int)Int

  product2(x => x * x)(3, 4)                      //> res3: Int = 144

  product2(x => x * x)(1, 5)                      //> res4: Int = 14400
}