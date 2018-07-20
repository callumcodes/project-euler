import org.scalatest.{AppendedClues, FlatSpec, Matchers}

class Problem5Spec extends FlatSpec with Matchers with AppendedClues {

  "solution" should "Find the smallest positive number that is evenly divisible by all of the numbers from 1 to 20" in {
    Problem5.solution shouldBe 232792560
  }

}