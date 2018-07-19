import scala.annotation.tailrec

object Problem4 {

  /*
    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

    Find the largest palindrome made from the product of two 3-digit numbers.
   */

  lazy val solution: Int = {
    (100 to 999).flatMap { i =>
      (100 to 999).map { j =>
        i * j
      }
    }.filter(isPalindrome).max
  }

  def isPalindrome(n: Int): Boolean = {

     def go(string: String): Boolean = {
       string.length match {
         case 1 => true
         case 2 if allCharsAreSame(string) => true
         case _ if string.head == string.last => go(string.drop(1).dropRight(1))
         case _ => false
       }
     }

    go(n.toString)
  }

  private def allCharsAreSame(s: String) = s.toSet.size == 1

}
