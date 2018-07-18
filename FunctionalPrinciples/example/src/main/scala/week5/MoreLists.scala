package week5

object MoreLists {

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => Nil
    case y :: ys => List(y) ++ init(ys)
  }

  def removeAt[T](n: Int, xs: List[T]) = {

  def removes[T](n: Int, xs: List[T], index: Int): List[T] = xs match {
    case Nil => Nil
    case y :: ys => if (index == n) ys else List(y) ++ removes(n, xs, index + 1)
  }

  removes(n,xs,0)

}

  removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

//  def flatten(xs: List[Any]): List[Any] = xs.:::flatten(xs.tail)

}
