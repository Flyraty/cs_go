/*
 * 机器人在矩阵中的运动范围，机器人不能通过数位之和大于 k 的格子。比如 k=18，则可以经过坐标 (35, 37)，而不能经过 (35, 38)。
 * 第一步根据矩阵的长宽生成数位之和的矩阵
 * 第二步深度优先搜索
 */
package algorithm

object robot_range {

  val notion = Seq(Seq(0, 1), Seq(0, -1), Seq(1, 0), Seq(-1, 0))

  var cnt = 0


  def initArray(rows: Int, cols: Int) = {
    val initArray = Array.ofDim[Int](Math.max(rows, cols))

    for (i <- 0 until initArray.length) {
      var n = i
      while (n > 0) {
        initArray(i) += n % 10
        n /= 10
      }
    }
    initArray
  }


  def initMatrixArray(rows: Int, cols: Int) = {
    val array = initArray(rows, cols)
    val matrixArray = Array.ofDim[Int](rows, cols)
    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        matrixArray(i)(j) = array(i) + array(j)
      }
    }
    matrixArray
  }

  def robot_range(rows: Int, cols: Int, threshold: Int) = {
    val marked = Array.ofDim[Boolean](rows, cols)
    val array = initMatrixArray(rows, cols)

    def dfs(r: Int, c: Int): Boolean = {
      if (r < 0 || r >= rows || c < 0 || c >= cols || marked(r)(c) || array(r)(c) > threshold) {
        return false
      }
      marked(r)(c) = true
      cnt += 1
      for (n <- notion) {
        dfs(r + n.head, c + n.last)
      }
      false
    }

    dfs(0, 0)
    cnt
  }

  def main(args: Array[String]): Unit = {
    println(robot_range(10, 10, 4))
  }


}
