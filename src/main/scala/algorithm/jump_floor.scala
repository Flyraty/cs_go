/*
 * 跳台阶问题，本质上也是递归问题，想要跳上第三阶，就要跳上第二阶，想要跳上第二阶，就要先跳上第一阶,
 * 跳台阶，可以跳1阶，可以跳2阶
 * 变态跳台阶，可以跳 n 阶
 */
package algorithm

object jump_floor {


  /**
    * 跳台阶，可以跳1阶，可以跳2阶
    *
    * @param n
    * @return
    */
  def jumpFloor(n: Int) = {
    if (n <= 2) {
      n
    } else {
      var fib = 0
      var pre1 = 2
      var pre2 = 1
      for (i <- 3 until n + 1) {
        fib = pre1 + pre2
        pre2 = pre1
        pre1 = fib
      }
      fib
    }
  }

  /**
    * 变态跳台阶，可以跳1阶，可以跳2阶，..... 可以跳 n 阶。如果想跳上n阶，可以选择跳上 n-1 阶 + 1阶，也可以是 n-2 + 2，依次类推，
    * f(n) = f(n-1) + f(n-2) + ...... + f(1) => f(n) = 2 * f(n-1)
    *
    * @param n
    */

  def jumpFloor1(n: Int) = {
    scala.math.pow(2, n - 1)
  }

  /**
    * 变态跳台阶，第 n 项和前面的所有项都有关，所以可以缓存前 n-1 项的和
    */

  def jumpFloor2(n: Int) = {
    val seq = Array.fill[Int](n)(1)

    for (i <- 1 until n) {
      for (j <- 0 until i) {
        seq(i) += seq(j)
      }
    }
    seq(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(jumpFloor(10))
    println(jumpFloor1(10))
    println(jumpFloor2(10))
  }


}
