package greedy

class MukBangLive {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var foodTimes = intArrayOf(3, 1, 2)
            var k = 5.toLong()
            require(solution(foodTimes, k) == 1)

            foodTimes = intArrayOf(2, 1, 2)
            k = 5.toLong()
            require(solution(foodTimes, k) == -1)

            foodTimes = intArrayOf(2, 1, 3, 1)
            require(solution(foodTimes, k) == 3)

            foodTimes = intArrayOf(2, 1, 3, 1, 7, 2, 1)
            k = 10.toLong()
            require(solution(foodTimes, k) == 6)

        }

        //정확성 30/32 효율성 0.0
        fun solution(food_times: IntArray, kLong: Long): Int {
            var k = kLong.toInt()
            var foodTimes = food_times.toMutableList()
            if (foodTimes.sum() <= k) return -1
            var cursor = 0
            while (k > 0) {
                if (foodTimes[cursor] > 0) {
                    k -= 1
                    foodTimes[cursor] -= 1
                }
                cursor += 1
                cursor %= foodTimes.size
            }
            for (i in cursor until foodTimes.size) {
                if (foodTimes[i] > 0) {
                    return i+1
                }
            }
            return -1
        }
    }
}

