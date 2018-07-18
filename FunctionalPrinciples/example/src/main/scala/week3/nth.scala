package week3
import week3.List

object nth {

  def nth[T](n: Int, l: List[T]): T = {
    if (l.isEmpty) throw new IndexOutOfBoundsException
    else if (n==0) l.head
    else nth(n-1,l.tail)

  }

}

class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

object Solution {
  def pathSum(root: TreeNode, sum: Int): Int = {
    def countPaths(root: TreeNode,count: Int,cur_sum: Int): Int = {
      if (root==null) count
      else if (cur_sum+root.value==sum) countPaths(root.left ,count+1,0) + countPaths(root.right ,count+1,0)
      else if (cur_sum+root.value>sum) countPaths(root.left ,count,root.value) + countPaths(root.right ,count,root.value)
      else countPaths(root.left ,count,cur_sum + root.value) + countPaths(root.right ,count,cur_sum + root.value)
    }

    countPaths(root,0,0)

  }


}
