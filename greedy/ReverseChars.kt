package greedy

import kotlin.math.min

class ReverseChars {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val input = readln()
            var groupOne = 0
            var groupZero = 0
            var prev = 'I'
//            if (prev == '0') groupZero += 1 else groupOne += 1
            input.map {
                if (prev != it) {
                    prev = it
                    if (it == '0') groupZero += 1 else groupOne += 1
                }
            }
            println(min(groupOne, groupZero))
        }

    }
}