/*
 * 旋转数组，把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 本质上是求数组的最小值，注意是非递减排序，有可能存在相等的数  12345 -> 34512   112333344 -> 334411233，
 */
package algorithm

import scala.util.control.Breaks.{break, breakable}

object spin_array_min {

  def spinArrayMin(seq: Seq[Int]) = {
    var min = 0
    if (seq.isEmpty) {
      min
    } else {
      var l = 0
      var h = seq.length - 1
      breakable(
        while (l < h) {
          val m = (l + h) / 2
          if (seq(l) == seq(m) && seq(m) == seq(h)) {
            min = minNum(seq, l, h)
            break
          }
          if (seq(m) > seq(h)) {
            l = m + 1
          }
          else {
            h = m
          }
          min = seq(l)
        })
      min
    }
  }

  def minNum(seq: Seq[Int], l: Int, h: Int) = {
    var min = 0
    breakable(
      for (i <- l until h) {
        if (seq(i) > seq(i + 1)) {
          min = seq(i + 1)
          break
        }
        else {
          min = seq(l)
        }
      })
    min
  }


  def main(args: Array[String]): Unit = {
    val seq = Seq(3, 3, 4, 4, 2, 2, 2, 3, 3)
    println(spinArrayMin(seq))
  }

}
