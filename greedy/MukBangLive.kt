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

            foodTimes = intArrayOf(7, 1, 1, 1, 2)
            k = 8.toLong()
            require(solution(foodTimes, k) == 1)
        }

        //정확성 32/32 효율성 0.0
        fun solution(food_times: IntArray, kLong: Long): Int {
            var k = kLong.toInt()
            var foodTimes = food_times.toMutableList()
            if (foodTimes.sum() <= k) return -1
            var cursor = 0
            //K 번째까지 먹고 난 다음 순서를 구해야해서 +1
            k += 1
            while (k > 0) {
                if (foodTimes[cursor] > 0) {
                    k -= 1
                    foodTimes[cursor] -= 1
                }
                // 위의 if 절에서 해당 순서에 먹을음식이 있으면 k에서 1 감소했으니 k가 0일때 탈출
                if (k == 0) {
                    println(cursor +1)
                    return (cursor+1)
                }
                cursor += 1
                cursor %= foodTimes.size
            }
            return -1
        }
    }
}

