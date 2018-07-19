import org.scalatest.{AppendedClues, FlatSpec, Matchers}

class Problem2Spec extends FlatSpec with Matchers with AppendedClues {

  "solution" should "Find the sum of even fib numbers below 4 million" in {
    Problem2.solution shouldBe 4613732
  }


  "fibs" should "return the fibbonaci numbers starting with 1 and 2" in {
    Problem2.fibs take 10 shouldBe List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
  }
}
