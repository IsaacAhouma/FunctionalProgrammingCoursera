object hof{
  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil => Nil
      case y :: ys => y*y::squareList(ys)
    }

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x*x)

  val l1 = List(1,10,20,30)

  squareList(l1)

  squareList2(l1)

  l1 filter(x => x > 10)


  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (s => s == x)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T,Int)] = {
    pack(xs) map (x => (x.head,x.length))

  }

  pack(List("a", "a", "a", "b", "c", "c", "a"))

  encode(List("a", "a", "a", "b", "c", "c", "a"))

  val data = List("a", "a", "a", "b", "c", "c", "a")

  def mapFun[T, U](xs: List[T], f: T => U): List[U] = {
    (xs foldRight List[U]())( (x,acc) => f(x)::acc)
  }

  def lengthFun[T](xs: List[T]): Int = {
    (xs foldRight 0) ((_, acc) => acc + 1)
  }
  mapFun[String,String](data,x => "z")

  lengthFun(data)
  lengthFun(Nil)
}