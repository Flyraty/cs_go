/*
 * 逆序打印链表
 */
package algorithm


object reverse_linklist {

  case class ListNode(var next: ListNode, var value: Int)

  import java.util

  def printListFromTailToHead(listNode: ListNode): util.ArrayList[Integer] = {
    val ret = new util.ArrayList[Integer]
    if (listNode != null) {
      ret.addAll(printListFromTailToHead(listNode.next))
      ret.add(listNode.value)
    }
    ret
  }

  def main(args: Array[String]): Unit = {
    val l1 = ListNode(null, 1)
    val l2 = ListNode(null, 2)
    val l3 = ListNode(null, 3)

    l1.next = l2
    l2.next = l3

    println(printListFromTailToHead(l1))
  }
}
