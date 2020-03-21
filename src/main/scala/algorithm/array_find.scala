/*
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 */
package algorithm

object array_find {

  import scala.util.control.Breaks.{break, breakable}

  def find(matrix: Array[Array[Int]], target: Int) = {
    var bool = false
    if (matrix == null || matrix(0).length == 0 || matrix.length == 0) {
      bool = false
    }
    val m = matrix.length
    val n = matrix(0).length
    var r = 0
    var c = n - 1
    breakable {
      while (r <= m - 1 && c >= 0) {
        target match {
          case a if (a > matrix(r)(c)) => r = r + 1
          case b if (b < matrix(r)(c)) => c = c - 1
          case j if (j == matrix(r)(c)) => bool = true; break
        }
      }
    }
    bool

  }

  def main(args: Array[String]): Unit = {
    val matrix = Array(
      Array(1, 4, 7, 11, 15),
      Array(2, 5, 8, 12, 19),
      Array(4, 8, 9, 14, 23),
      Array(5, 9, 10, 15, 24),
      Array(7, 12, 13, 16, 25)
    )
    println(find(matrix, 9))
  }

}
