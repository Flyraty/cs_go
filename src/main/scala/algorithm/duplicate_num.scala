/*
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 要求时间复杂度 O(N)，空间复杂度 O(1)
 * Input: {2, 3, 1, 0, 2, 5}
 * OutPut: 2
 */

package algorithm

object duplicate_num {

  // 因为要求时间复杂度 O(N)，空间复杂度 O(1)，所以是遍历一次数组找到重复的数据，且不能申请标记数组。
  import scala.util.control.Breaks.{break, breakable}

  def swap(nums: scala.collection.mutable.Seq[Int], i: Int, j: Int) = {
    val t = nums(i)
    nums(i) = nums(j)
    nums(j) = t
  }

  def duplicate(nums: scala.collection.mutable.Seq[Int]) = {
    var duplicate_num = 0
    breakable {
      for (i <- 0 until nums.length) {
        while (nums(i) != i) {
          if (nums(i) == nums(nums(i))) {
            duplicate_num = nums(i)
            break
          }
          swap(nums, i, nums(i))
        }
      }
    }
    duplicate_num

  }

  def main(args: Array[String]): Unit = {
    val seq = scala.collection.mutable.Seq(1, 3, 4, 0, 4, 3)
    println(duplicate(seq))
  }

}
