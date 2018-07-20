import scala.annotation.tailrec

object Problem5 {

  /*
    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
   */

  lazy val solution = {

    val mostCommonPrimeFactors: Seq[Map[Int, Int]] = (2 to 20).map(primeFactors(_).groupBy(identity).mapValues(_.size))

    mergeMaps(mostCommonPrimeFactors).map {
      case (number, occurrence) => scala.math.pow(number, occurrence)
    }.product
  }

  private def mergeMaps(maps: Seq[Map[Int, Int]]): Map[Int, Int] = {
    // Collect the keys
    val keys: Set[Int] = maps.flatMap(_.keySet).toSet

    //  Find the highest value for that key in the maps
    keys.map { key =>
      (key, maps.flatMap(_.get(key)).max)
    }.toMap
  }


  def primeFactors(n: Int): List[Int] = {

    @tailrec
    def go(value: Int, factors: List[Int], remainingPrimes: Stream[Int]): List[Int] = {

      if (value <= 1) factors
      else {
        val currentPrime = remainingPrimes.head
        if (isDivisibleBy(value, currentPrime)) {
          go(value / currentPrime, currentPrime :: factors, remainingPrimes)
        } else {
          go(value, factors, remainingPrimes.drop(1))
        }
      }
    }

    go(n, Nil, primes).sorted
  }

  private def isDivisibleBy(x: BigInt, n: BigInt) = x % n == 0

  val primes = 2 #:: Stream.from(3, 2).filter(isPrime)
  private def isPrime(n: Int): Boolean = primes.takeWhile(p => p * p <= n).forall(n % _ != 0)

}
