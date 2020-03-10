/*
 * 斐波那契数列，n <= 39
 */
package algorithm

import scala.collection.mutable.ListBuffer

object fibonacci {

  /*
   * 常见的递归解法，存在 n-2 次重复计算
   */
  def fibonacci(n: Int): Int = {
    if (n <= 1) {
      n
    } else {
      fibonacci(n - 2) + fibonacci(n - 1)
    }
  }

  /*
   * 动态规划，给计算好的数据加上缓存，不重复计算，这样空间复杂度为 n
   */
  def fibonacci1(n: Int) = {
    if (n <= 1) {
      n
    } else {

      val seq = new ListBuffer[Int]()
      seq += 0
      seq += 1
      for (i <- 2 until n + 1) {
        seq += (seq(i - 2) + seq(i - 1))
      }
      seq(n)
    }
  }

  /*
   * 降低空间复杂度，只需要缓存前每一项前2条数据就可以，不必缓存所有，空间复杂度为 O(1)
   */
  def fibonacci2(n: Int) = {
    if (n <= 1) {
      n
    } else {

      var pre1 = 1
      var pre2 = 0
      var fib = 0
      for (i <- 2 until n + 1) {
        fib = pre2 + pre1
        pre2 = pre1
        pre1 = fib
      }
      fib
    }
  }

  /*
   * 降低时间复杂度，因为 n<=39，可以先计算好所有数据放入列表，然后直接取数
   */
  def fibonacci3(n: Int) = {
    if (n <= 1) {
      n
    } else {
      val seq = new ListBuffer[Int]()
      seq += 0
      seq += 1
      for (i <- 2 until 40) {
        seq += seq(i - 2) + seq(i - 1)
      }
      seq(n)
    }
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(10))
    println(fibonacci1(10))
    println(fibonacci2(10))
    println(fibonacci3(10))
  }

}
