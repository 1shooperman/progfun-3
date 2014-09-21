package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r < 0 || c < 0 || r - c < 0) 0
    else if (r - c == 0) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def _balanced(chars: List[Char], acc: Int, y: Boolean): Boolean = {
      if (chars.isEmpty) (acc == 0)
      else if (chars.head == "(".toList.head) _balanced(chars.tail, acc + 1, true)
      else if (chars.head == ")".toList.head && y) _balanced(chars.tail, acc - 1, !((acc - 1) == 0))
      else if (chars.head != "(".toList.head && chars.head != ")".toList.head) _balanced(chars.tail, acc, y)
      else false
    }
    _balanced(chars, 0, false)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    val coins2 = coins.sorted
    def _countChange(money: Int, m: Int): Int = {
      if (money == 0) 1
      else if (money < 0) 0
      else if (m < 0 && money >= 1) 0
      else _countChange(money, m - 1) + _countChange(money - coins2(m), m)
    }
    if (money < 1 || coins.isEmpty) 0
    else _countChange(money, coins.size - 1)
  }
}
