package codingExercises


object fibonacci {
  def f(n: Int) = {

    def fibonacci(n: Int, acc: Int): Int = {
      if (n<1) acc
      else fibonacci(n-1,acc+n)
    }
    fibonacci(n,0)
  }

f(8)

}
