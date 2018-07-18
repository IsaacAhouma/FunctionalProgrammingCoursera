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


  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  sum(x => x*x*x)(0,3)


  def product(f: Int => Int)(a: Int, b: Int): Int ={
    @tailrec
    def product(a: Int, acc: Int): Int = {
      if (a > b) acc else product(a+1,f(a)*acc)
    }

    product(a, 1)
  }

  product(x => x)(1,5)

  def myfactorial(n: Int): Int = product(x => x)(1,n)

  myfactorial(4)

  def mapReduce(combine: (Int,Int) => Int)(f: Int => Int)(zero: Int)(a: Int, b:Int): Int = {
    def loop(a:Int, acc: Int): Int = {
      if (a>b) acc else loop(a+1,combine(acc,f(a)))
    }

    loop(a,zero)
  }

  def mySum(f: Int => Int)(a: Int, b: Int): Int ={
    mapReduce((x,y) => x+y)(f)(0)(a,b)
  }

  def myProd(f: Int => Int)(a: Int, b: Int): Int ={
    mapReduce((x,y) => x*y)(f)(1)(a,b)
  }

  myProd(x=>x)(1,5)
  mySum(x=>x)(1,5)




}