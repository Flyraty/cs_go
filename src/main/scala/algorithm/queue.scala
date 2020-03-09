/*
 * 用栈来实现队列的 push 和 pop 操作
 */
package algorithm

import scala.collection.mutable.Stack

object queue {

  val in = Stack[Int]()
  val out = Stack[Int]()

  def push(x: Int) = {
    in.push(x)
  }

  def pop() = {
    if(out.isEmpty) {
      while (!in.isEmpty) {
        out.push(in.pop)
      }
    }

    out.pop()
  }

  def main(args: Array[String]): Unit = {
    queue.push(1)
    queue.push(2)
    queue.push(3)
    println(queue.pop())
  }

}
