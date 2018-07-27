import math.Ordering
object mergeSort{
  def mergeSort[T](list: List[T])(lt: (T,T) => Boolean): List[T] = {
    val mid = list.length /2
    if (mid==0) list
    else {
      //    def merge(l1: List[Int], l2:List[Int]):List[Int] = l1 match{
      //      case Nil => l2
      //      case x::xs => l2 match{
      //        case Nil => l1
      //        case y::ys => x<y match{
      //          case true => x::merge(xs,l2)
      //          case false => y::merge(l1,ys)
      //        }
      //      }
      //    }
      def merge[T](l1: List[T], l2:List[T]):List[T] = (l1,l2) match{
        case (Nil,_) => l2
        case(_,Nil) => l1
        case(x::xs,y::ys) => if (lt(x,y)) x::merge(xs,l2) else y::merge(l1,ys)
      }

      def splitAt[T](ints: List[T], i: Int) = (ints take i,ints takeRight i)
      val (first,second) = splitAt(list,mid)
      merge(mergeSort(first)(lt),mergeSort(second)(lt))
    }

  }


  val sorted = List(2,-4,5,7,1)
  mergeSort(sorted)((x:Int,y:Int) => x < y)
}



