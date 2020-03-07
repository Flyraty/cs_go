/*
 * 给定一个二叉树和其中的一个结点，返回中序遍历顺序下的的下一个结点值
 * 中序遍历：左子树 -> 根节点 -> 右子树
 * 如果存在右子树，就一直寻找该右子树下的最左结点
 * 如果不存在右子树，就一直寻找父节点，直到父节点的左节点 = 当前结点为止，否则已经没有下一个节点了
 *
 */
package algorithm

object next_tree_node {

  case class Tree(var left:Tree, var right:Tree, var parent:Tree, var value:Int)


  def findNextNode(node:Tree):Any = {
    var node_ = node
    if (node.right != null){
      var next_node = node.right
      while(next_node.left != null){
        next_node = node.left
      }
      return next_node
    } else {
      while (node.parent != null) {
        val next_node = node.parent
        if (next_node.left == node_){
          return next_node
        }
        node_ = node_.parent
      }
    }
    null

  }

  def main(args: Array[String]): Unit = {
    val node1 = Tree(null, null, null, 1)
    val node2 = Tree(null, null, null, 2)
    val node3 = Tree(null, null, null, 3)
    val node4 = Tree(null, null, null, 4)
    val node5 = Tree(null, null, null, 5)

    node1.left = node2
    node1.right = node3

    node2.left = node4
    node2.right = node5


    node2.parent = node1
    node3.parent = node1
    node4.parent = node2
    node5.parent = node2

    println(findNextNode(node3))



  }

}
