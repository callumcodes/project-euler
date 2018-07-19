import org.scalatest.{AppendedClues, FlatSpec, Matchers}

class Problem1Spec extends FlatSpec with Matchers with AppendedClues {

  "solution" should "Find the sum of all the multiples of 3 or 5 below 1000." in {
    Problem1.solution shouldBe 233168
  }

  "multiple of three and five" should "return true for 3, 6, 9 etc." in {
    Stream.range(3, 1000, 3).foreach { n =>
      Problem1.multipleOfThreeAndFive(n) shouldBe true withClue s"Failed for $n"
    }
  }

  it should "return true for 5, 10, 15 etc." in {
    Stream.range(5, 1000, 5).foreach { n =>
      Problem1.multipleOfThreeAndFive(n) shouldBe true withClue s"Failed for $n"
    }
  }

  it should "return false for 0, 1, 2, 4, 22, 82" in {
    List(0, 1, 2, 4, 22, 82).foreach { n =>
      Problem1.multipleOfThreeAndFive(n) shouldBe false withClue s"Failed for $n"
    }
  }

}
