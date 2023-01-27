package `03greedy`

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class BigNumerSum {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val input = readln().split(" ")
            val n = input[0].toInt()
            val m = input[1].toInt()
            val k = input[2].toInt()
            val numbers = readln().split(" ").map { it.toInt() }.sortedDescending()

            val start = LocalDateTime.now()
            println(solution(n, m, k, numbers))

            val diff = ChronoUnit.SECONDS.between(LocalDateTime.now(), start)
            println("duration: $diff")

        }

        private fun solution (n:Int, m: Int, k: Int, numbers: List<Int>): Int {
            //총길이 m, 중복은 최대 k번
            var resultSum = 0
            val count = m / (k + 1)
            resultSum += (numbers[0] * k + numbers[1]) * count
            val restCount = m % (k + 1)
            resultSum += numbers[0] * restCount
            return resultSum
        }
    }
}