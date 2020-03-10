/*
 * 矩形覆盖问题，其实就是斐波那契数列
 * 又是递归问题
 */
package algorithm

object rect_cover {

  def rect_cover(n: Int) = {
    if (n <= 2) {
      n
    } else {
      var pre1 = 2
      var pre2 = 1
      var fib = 0
      for (i <- 3 until n + 1) {
        fib = pre2 + pre1
        pre2 = pre1
        pre1 = fib
      }
      fib
    }
  }

}
