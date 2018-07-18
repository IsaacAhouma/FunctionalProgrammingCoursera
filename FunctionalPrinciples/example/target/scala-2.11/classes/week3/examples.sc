import week3._

object week3{
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1.incl(4)
//  println(t2.toString)

}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(s: IntSet): IntSet
}

object Empty extends IntSet{
  def incl(x: Int) = new NonEmpty(x, Empty, Empty)

  def contains(x: Int): Boolean = false

  def union(s: IntSet) = s

  override def toString: String = "."
}

class NonEmpty(element: Int, left: IntSet, right: IntSet) extends IntSet{

  def incl(x: Int) = {
    if (x<element) new NonEmpty(element, left incl x, right)
    else if (x>element) new NonEmpty(element,left, right incl x)
    else this

  }

  def contains(x: Int) = {
    if (x<element) left contains x
    else if (x>element) right contains x
    else true
  }

  def union(s: IntSet) = {
    left union s incl this.element union right
  }

  override def toString: String = {
    "{" + left + element + right + "}"
  }



}