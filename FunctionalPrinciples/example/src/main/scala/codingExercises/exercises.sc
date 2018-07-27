object fibonacci {
  def f(n: Int) = {

    def fibonacci(n: Int, acc: Int): Int = {
      if (n<1) acc
      else fibonacci(n-1,acc+n)
    }
    fibonacci(n,0)
  }

  f(15)
  f(5)
  f(10)
  f(8181)
  f(200)
  f(198)+f(199)

}