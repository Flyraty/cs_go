/*
 * 剪绳子问题，长度为n的绳子，剪完之后乘积最大
 * 动态规划，
 * 长度为 1 => 1
 * 长度为 2 => 1
 * 长度为 3 => 2
 * 长度为 4 => max(f(1)f(3), f(2)f(2))
 * 长度为 5 => max(f(1)f(4), f(2)f(3), f(3)f(1))
 */
package algorithm

object cut_rope {

  def cutRope(n: Int): Int = {
    val array = Array.ofDim[Int](n + 1)
    array(1) = 1

    for (i <- 2 until n+1) {
      for (j <- 1 until i) {
        array(i) = Math.max(array(i), Math.max(j * (i - j),  j * array(i - j)))
      }
    }
    array(n)
  }

  def main(args: Array[String]): Unit = {
    println(cutRope(10))
  }

}
