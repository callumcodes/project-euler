import java.math.BigInteger

import scala.annotation.tailrec

object Problem3 {

  /*
    The prime factors of 13195 are 5, 7, 13 and 29.

    What is the largest prime factor of the number 600851475143 ?
   */


  lazy val solution: BigInt = {
    primeFactors(BigInt("600851475143")).max
  }

  def primeFactors(n: BigInt): List[BigInt] = {

    @tailrec
    def go(value: BigInt, factors: List[BigInt], remainingPrimes: Stream[BigInt]): List[BigInt] = {
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

  val primes = BigInt(2) #:: Stream.range(start = BigInt(3), end = BigInt("999999999999"), step = BigInt(2)).filter(isPrime)
  private def isPrime(n: BigInt): Boolean = primes.takeWhile(p => p * p <= n).forall(n % _ != 0)
}
