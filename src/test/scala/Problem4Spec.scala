import org.scalatest.{AppendedClues, FlatSpec, Matchers}

class Problem4Spec extends FlatSpec with Matchers with AppendedClues {

  "solution" should "Find the largest prime factor of 600851475143" in {
    Problem4.solution shouldBe 906609
  }

  "isPalindrome" should "return true for any single digit" in {
    (0 until 10).foreach { n =>
      Problem4.isPalindrome(n) shouldBe true withClue(s"Failed for $n")
    }
  }

  "isPalindrome" should "return false for any two digit numbers that are different and true for ones which are the same" in {

    val correctExamples = List(11, 22, 33, 44, 55, 66, 77, 88, 99)
    val badExamples = (10 until 100).filterNot(correctExamples.contains(_))
    correctExamples.foreach { n =>
      Problem4.isPalindrome(n) shouldBe true withClue(s"Failed for $n")
    }
    badExamples.foreach { n =>
      Problem4.isPalindrome(n) shouldBe false withClue(s"Failed for $n")
    }
  }

  it should "work for 3+ digit palindromes" in {
    val examples = List(121, 11311, 14841, 55555555)
    examples.foreach { n =>
      Problem4.isPalindrome(n) shouldBe true withClue(s"Failed for $n")
    }
  }

}
