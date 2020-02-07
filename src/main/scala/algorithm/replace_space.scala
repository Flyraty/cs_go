/*
 * 将一个字符串中的空格替换成 "%20"
 * Input: "A B"
 * OutPut: "A%20B"
 */
package algorithm

object replace_space {

  def replaceSpace(str: StringBuilder) = {
    var p1 = str.length
    for (i <- 0 until p1) {
      if (str(i).toString == " ") {
        str.append("  ")
      }
    }
    var p2 = str.length - 1
    while (p1 >= 0 && p2 > p1) {
      val c = str(p1 - 1)
      if (str(p1 - 1) == " ".head) {
        str.setCharAt(p2, "0".head)
        p2 -= 1
        str.setCharAt(p2, "2".head)
        p2 -= 1
        str.setCharAt(p2, "%".head)
      } else {
        str.setCharAt(p2, c)
        p2 -= 1
      }
      p1 -= 1
    }

    str.toString()
  }

  def main(args: Array[String]): Unit = {
    val str = new StringBuilder
    str ++= "A B"
    println(replaceSpace(str))
  }

}
