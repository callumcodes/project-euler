object Problem1 {

  /*
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

    Find the sum of all the multiples of 3 or 5 below 1000.
   */

  lazy val solution: Int = {
    (1 until 1000).filter(multipleOfThreeAndFive).sum
  }

  def multipleOfThreeAndFive(n: Int): Boolean = {
    n > 0 && (n % 3 == 0 || n % 5 == 0)
  }

}
