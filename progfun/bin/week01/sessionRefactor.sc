//package week01

object sessionRefactor {
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(0.001)                                     //> res2: Double = 0.03162278245070105
  sqrt(0.1e-20)                                   //> res3: Double = 3.1633394544890125E-11
  sqrt(1.0e20)                                    //> res4: Double = 1.0000021484861237E10
  sqrt(1.0e50)                                    //> res5: Double = 1.0000003807575104E25

}