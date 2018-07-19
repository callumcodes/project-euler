import org.scalatest.{AppendedClues, FlatSpec, Matchers}

class Problem3Spec extends FlatSpec with Matchers with AppendedClues {

  "solution" should "Find the largest prime factor of 600851475143" in {
    Problem3.solution shouldBe 6857
  }

  "primeFactors" should "return the prime factors of a number for 2" in {

    val examples = List(
      2 -> List(2),
      3 -> List(3),
      4 -> List(2, 2),
      5 -> List(5),
      6 -> List(2, 3),
      7 -> List(7),
      9 -> List(3, 3),
      11 -> List(11),
      15 -> List(3, 5),
      101 -> List(101),
      132 -> List(2, 2, 3, 11),
      990 -> List(2, 3, 3, 5, 11)
    )

    examples.foreach {
      case (q, answer) => Problem3.primeFactors(q) shouldBe answer withClue s"Failed for $q"
    }
  }

  "primes" should "return the prime numbers" in {
    Problem3.primes.take(10) shouldBe List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
  }

}
