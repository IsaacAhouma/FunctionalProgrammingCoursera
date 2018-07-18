


abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}



class Successor(pred: Nat) extends Nat {
  def isZero = false

  def predecessor = pred
  def successor = new Successor(this)


  def +(that: Nat) = {
    new Successor(pred + that)
//    def helper(acc1: Nat, acc2: Nat): Nat = {
//      if (acc2.isZero) acc1
//      else helper(acc1.successor, acc2.predecessor)
//    }
//
//    helper(this, that)
  }

  def -(that: Nat) = {
    if (that.isZero) this else pred - that.predecessor

//    def helper(acc1: Nat, acc2: Nat): Nat = {
//      if (acc2.isZero) acc1
//      else if (acc1.isZero) throw new NoSuchElementException
//      else helper(acc1.predecessor, acc2.predecessor)
//    }
//
//    helper(this, that)
  }

  class Zero extends Nat{
    def isZero = true
    def predecessor = throw new NoSuchElementException
    def successor = new Successor(this)

    def +(that: Nat) = that
    def -(that: Nat) = if (that.isZero) that else throw new NoSuchElementException
  }

  object Naturals {
    val zero = new Zero
    val one = new Successor(zero)
    val two = new Successor(one)

    two.isZero
    one + two
    zero + two
    two - one
    one - two
    two + one
  }

  trait Expr {
  }
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  def show(e: Expr): String = this match {
    case Number(n) => n.toString
    case Sum(e1: Expr, e2: Expr) => show(e1) + "+" + show(e2)

  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x<=y) x :: xs else y :: insert(x,ys)
  }




  val one = Number(1)
  val two = Number(2)
  val three = Sum(one,two)

  show(one)
  show(three)


}


