/*
 * 二叉树的前，中，后序遍历的递归和非递归实现
 */
package algorithm

import scala.collection.mutable.Stack


object tree {

  case class Tree(var left: Tree, var right: Tree, var value: Int)

  /*
   * 前序遍历
   */
  def preOrderTraverse(tree: Tree): Unit = {
    if (tree != null) {
      println(tree.value)
      preOrderTraverse(tree.left)
      preOrderTraverse(tree.right)
    }
  }

  def preOrderTraverseV1(tree: Tree) = {
    val s = Stack[Tree]()
    var root = tree
    while (root != null || !s.isEmpty) {
      if (root != null) {
        println(root.value)
        s.push(root)
        root = root.left
      } else {
        root = s.pop().right
      }
    }


  }

  /*
   * 中序遍历
   */
  def inOrderTraverse(tree: Tree): Unit = {
    if (tree != null) {
      inOrderTraverse(tree.left)
      println(tree.value)
      inOrderTraverse(tree.right)
    }
  }

  def inOrderTraverseV1(tree: Tree) = {
    val s = Stack[Tree]()
    var root = tree
    while (root != null || !s.isEmpty) {
      if (root != null) {
        s.push(root)
        root = root.left
      } else {
        val node = s.pop()
        println(node.value)
        root = node.right
      }
    }
  }

  /*
   * 后序遍历
   * 非递归，如果某个结点存在左子树，记录下当前结点，访问左节点，访问当前结点右结点下的最左结点，如果当前节点不存在右子树，返回当前节点。
   * 某个被访问的前提是当前结点没有右子树或者右子树已经被访问过
   */
  def postOrderTraverse(tree: Tree): Unit = {
    if (tree != null) {
      postOrderTraverse(tree.left)
      postOrderTraverse(tree.right)
      println(tree.value)
    }
  }

  def postOrderTraverseV1(tree: Tree) = {
    val s = Stack[Tree]()
    var root = tree
    var lastVisit = root
    var curNode = root
    while (root != null) {
      s.push(root)
      root = root.left
    }

    while (!s.isEmpty) {
      curNode = s.pop()
      if (curNode.right != null && curNode.right != lastVisit) {
        s.push(curNode)
        curNode = curNode.right
        while (curNode != null) {
          s.push(curNode)
          curNode = curNode.left
        }
      } else {
        println(curNode.value)
        lastVisit = curNode
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val node1 = Tree(null, null, 1)
    val node2 = Tree(null, null, 2)
    val node3 = Tree(null, null, 3)
    val node4 = Tree(null, null, 4)
    val node5 = Tree(null, null, 5)
    val node6 = Tree(null, null, 6)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.right = node6

    preOrderTraverse(node1)
    preOrderTraverseV1(node1)

    inOrderTraverse(node1)
    inOrderTraverseV1(node1)

    postOrderTraverse(node1)
    postOrderTraverseV1(node1)
  }
}
