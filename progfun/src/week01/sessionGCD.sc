

object sessionGCD {

  // Euclid's algorith
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)              //> gcd: (a: Int, b: Int)Int

  //  def factorial(n: Int): Int =
  //    if (n == 0) 1 else n * factorial(n - 1)

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> factorial: (n: Int)Int

}