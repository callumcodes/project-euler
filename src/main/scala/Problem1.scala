object Problem1 {

  lazy val solution: Int = {
    (1 until 1000).filter(multipleOfThreeAndFive).sum
  }

  def multipleOfThreeAndFive(n: Int): Boolean = {
    n > 0 && (n % 3 == 0 || n % 5 == 0)
  }

}
