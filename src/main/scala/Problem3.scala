import java.math.BigInteger

import scala.annotation.tailrec

object Problem3 {

  /*
    The prime factors of 13195 are 5, 7, 13 and 29.

    What is the largest prime factor of the number 600851475143 ?
   */


  lazy val solution: Int = {
    primeFactors(BigInt("600851475143")).max
  }

  def primeFactors(n: BigInt): List[Int] = {

    @tailrec
    def go(value: BigInt, factors: List[Int], remainingPrimes: Stream[Int]): List[Int] = {
      value match {
        case x if x <= 1 => factors
        case x =>
          val current = remainingPrimes.head
          if (isDivisibleBy(value, current)) {
            go(value / current, current :: factors, remainingPrimes)
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
