import scala.annotation.tailrec

object week1 {

  def abs(x: Double): Double = if (x>0) x else -x

  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double) : Double =
      if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess*guess - x)/x < 0.001

    def improve(guess: Double) = (guess + x/guess) / 2

    sqrtIter(1.0)

  }



  sqrt(0.01)
  sqrt(0.001)
  sqrt(1e60)

//  @tailrec
//  def factorial(n: Int): Int =
//    {
//      def factorial(n: Int, acc: Int): Int =
//        if (n==0) acc else factorial(n-1,n*acc)
//
//      factorial(n,1)
//    }
//

  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n==0) acc else factorial(n-1,n*acc)

  factorial(5,1)

}