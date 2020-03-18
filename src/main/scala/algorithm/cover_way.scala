/*
 * 求解矩阵中是否存在字符串路径
 * 回溯法解决，矩阵中的每个点的下一个点都可以假设为有4个去向，如此循环直到找到一条完整的路径，如果找不到，重新选起点，重新开始上一套流程
 * 需要记录每个点的使用状态，不走已经使用过的点
 */
package algorithm

object cover_way {

  val notion = Seq(Seq(0, 1), Seq(0, -1), Seq(1, 0), Seq(-1, 0))

  def coverWay(matrixArray: Array[Array[String]], str: String):Boolean = {
    val row = matrixArray.length
    val col = matrixArray.head.length
    val marked = Array.ofDim[Boolean](row, col)
    if (row == 0 || col == 0) {
      return false
    }
    else {
      def backTracking(marked:Array[Array[Boolean]], sLen:Int, r:Int, c:Int):Boolean ={
        if (sLen == str.length){
          return true
        }
        if (r < 0 || r > row || c < 0 || c > col || matrixArray(r)(c) != str(sLen).toString || marked(r)(c)) {
          return false
        }
        println(matrixArray(r)(c))
        marked(r)(c) = true
        for (n <- notion) {
          if (backTracking(marked, sLen+1, r+n.head, c+n(1))) {
            return true
          }
        }
        marked(r)(c) = false // 之所以要在置为 false，是因为该路径可能只是满足前面几个条件，不完整，需要重新搜索起点。
        false
      }

      for (i <- 0 until row) {
        for (j <- 0 until col){
          if (backTracking(marked, 0, i, j)){
            return true
          }
        }

      }
      false
    }
  }



  def main(args: Array[String]): Unit = {
    val array = Array(
      Array("a", "b", "c", "d"),
      Array("e", "f", "g", "h"),
      Array("i", "j", "k", "l"),
      Array("m", "n", "o", "p")
    )

    println(coverWay(array, "gkjf"))
  }
}
