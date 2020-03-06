/*
 * 根据前序遍历和中序遍历的结果重构二叉树, 各个结点没有重复
 * pre [3, 9, 20, 15, 7]
 * middle [9, 3, 15, 20, 7]
 * 后序和中序也是一样的，确定根结点，确定左右子树的大小，递归查找问题
 * 前序和后序，确定根节点，划分左右子树
*/
package algorithm
import scala.util.control.Breaks.{break, breakable}

object rebuild_tree {

  case class Tree(var left:Tree, var right:Tree, var value:Int)

  def find(x: Int, seq:Seq[Int]) = {
    var a = 0
    breakable(
      for (i <- 0 to seq.length){
        a = i
        if(seq(i) == x ) break()
      }
    )
    a
  }

  def reBuildTree(pre:Seq[Int], middle:Seq[Int]):Tree = {
    if (pre.isEmpty) {
      null
    }
    else{
      val root = pre.head
      val tree = Tree(null, null, root)
      val root_pos = find(root, middle)
      val left = middle.slice(0, root_pos)
      val right = middle.slice(root_pos + 1, pre.length)
      val left_tree_size = left.length
      tree.left = reBuildTree(pre.slice(1, left_tree_size+1), left)
      tree.right = reBuildTree(pre.slice(left_tree_size+1, pre.length), right)
      tree
    }

  }

  def main(args: Array[String]): Unit = {
    val pre = Seq(3, 9, 20, 15, 7)
    val middle = Seq(9, 3, 15, 20, 7)
    println(reBuildTree(pre, middle))
  }


}
