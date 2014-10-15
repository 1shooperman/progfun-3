package patternmatch

trait Expr {
//  def eval = this match {
//    case Number(n) => n
//    case Sum(e1, e2) => e1.eval + e2.eval
//  }
}

class Number(n: Int) extends Expr {
  
}
object Number {
  def apply(n: Int) = new Number(n)
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  
}
object Sum {
  def apply(e1: Expr, e2: Expr) = new Sum(e1, e2)
}