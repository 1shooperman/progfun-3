import week4._
//import patternmatch._

object scratch {
  //	def eval1(e: Expr): Int = {
  //    if (e.isNumber) e.numValue
  //    else if (e.isSum) eval1(e.leftOp) + eval1(e.rightOp)
  //    else throw new Error("Unknown expression " + e)
  //  }

  //  def num1 = new week4.Number(1)
  //  def num2 = new week4.Number(2)
  //  def sum = new week4.Sum(num1, num2)
  //  eval1(sum)

  def show(e: Expr): String = e match {
    case Number(n: Int) => n.toString
    case Sum(e1: Expr, e2: Expr) => show(e1) + " + " + show(e2)
  }                                               //> show: (e: week4.Expr)String
  
  
  show(Number(1))                                 //> res0: String = 1
  show(Sum(Number(1),Number(44)))                 //> res1: String = 1 + 44

}