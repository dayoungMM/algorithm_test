package greedy

import java.util.PriorityQueue

class MukBangLive {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var foodTimes = intArrayOf(3, 1, 2)
            var k = 5.toLong()
            require(answer(foodTimes, k) == 1)

            foodTimes = intArrayOf(2, 1, 2)
            k = 5.toLong()
            require(answer(foodTimes, k) == -1)

            foodTimes = intArrayOf(2, 1, 3, 1)
            require(answer(foodTimes, k) == 3)

            foodTimes = intArrayOf(2, 1, 3, 1, 7, 2, 1)
            k = 10.toLong()
            require(answer(foodTimes, k) == 6)

            foodTimes = intArrayOf(7, 1, 1, 1, 2)
            k = 8.toLong()
            require(answer(foodTimes, k) == 1)
        }

        //정확성 32/32 효율성 0.0
        fun mysolution1(food_times: IntArray, kLong: Long): Int {
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

        //정확성 29/32 효율성 0.0
        fun mysolution2(food_times: IntArray, kLong: Long): Int {
            var k = kLong.toInt()
            var foodTimes = food_times.toMutableList()
            if (foodTimes.sum() <= k) return -1
            var cursor = 0
            //K 번째까지 먹고 난 다음 순서를 구해야해서 +1
            k += 1
            // 0인 접시가 나오지 않는 구간
            val minNum = foodTimes.min()
            for (i in 0 until foodTimes.size) {
                foodTimes[i] -= minNum
            }
            k -= minNum * foodTimes.size

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

        // 우선순위 큐를 이용함으로써 offer, poll 의 시간복잡도를 O(logN)으로 낮춤
        //
        fun answer(food_times: IntArray, kLong: Long): Int {
            var k = kLong.toInt()
            if (food_times.sum() <= k) return -1

            // 시간이 작은 음식부터 빼야하므로 우선순위 큐 사용
            val q = PriorityQueue<Pair<Int, Int>>(Comparator.comparing{it.first})
            for (i in 0 until food_times.size) {
                // (음식시간, 음식 번호) 로 add
                q.add(Pair(food_times[i], i+1))
            }

            //먹기 위해 사용한 시간
            var sumValue = 0
            //직전에 다 먹은 음식 시간
            var previous = 0
            // 남은 음식 개수
            var length  = food_times.size

            //남은 음식을 전체 한바퀴 돌릴 수 있으면 다 먹고, 다 먹은 음식 제외
            // 전체 한바퀴 돌릴 수 없을때까지 반복
            println("peek> ${q.peek()}")
            while ((q.peek().first - previous) * length <= k - sumValue){
                val nowTime = q.poll().first
                sumValue += (nowTime - previous) * length
                // 음식 한개 제거
                length -= 1
                previous = nowTime
            }

            // 남은 음식 중에서 몇번째인지 구하기 (먹을횟수 % 남은음식수)
            val eatCount = (k - sumValue) % length
            // 남은 음식 정렬
            val sortedFood = q.sortedBy { it.second }
            return sortedFood[eatCount].second

        }

        fun solution(food_times: IntArray, kLong: Long): Int {
            var k = kLong.toInt()
            var answer = -1
            if (food_times.sum() <= k) return -1

            // 시간이 작은 음식부터 빼야하므로 우선순위 큐 사용
            val q = PriorityQueue<Pair<Int, Int>>(Comparator.comparing{it.first})
            for (i in 0 until food_times.size) {
                // (음식시간, 음식 번호) 로 add
                q.offer(Pair(food_times[i], i+1))
            }

            //직전에 다 먹은 음식 시간
            var previous = 0
            // 남은 음식 개수
            var length  = food_times.size

            //남은 음식을 전체 한바퀴 돌릴 수 있으면 다 먹고, 다 먹은 음식 제외
            // 전체 한바퀴 돌릴 수 없을때까지 반복
            while (q.size > 0) {
                val diff = (q.peek().first - previous) * length
                if (diff <= k) {
                    k -= diff
                    length -=1
                    previous = q.poll().first
                } else {
                    //한사이클을 돌리지 못하기 때문에 k와 남은 음식 개수를 나눈 나머지가 해당 인덱스가 된다
                    val idx = k % length
                    val sortedFood = q.sortedBy { it.second }
                    answer = sortedFood[idx].second
                    break
                }
            }
            return answer

        }
    }


}

