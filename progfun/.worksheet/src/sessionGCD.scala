

object sessionGCD {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(115); 

  // Euclid's algorith
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(229); 

  //  def factorial(n: Int): Int =
  //    if (n == 0) 1 else n * factorial(n - 1)

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""")}

}
