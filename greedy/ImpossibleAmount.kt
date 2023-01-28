package greedy

class ImpossibleAmount {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val n = readln().toInt()
            val input = readln().split(" ").map { it.toInt() }
            println(mysolution(n, input))
            println(answer(n, input))
        }

        private fun mysolution(n: Int, data: List<Int>): Int {
            val input = data.sorted()
            var minNum = 1
            var loop = true
            while (loop) {
                var smallerNums = mutableListOf<Int>()

                for (i in 0 until n) {
                    if (input[i] <= minNum) smallerNums.add(input[i]) else break
                }
                var target = 0
                for (i in smallerNums.size - 1 downTo 0) {

                    if ((target + smallerNums[i]) == minNum) {
                        // 더했을 때 숫자 만들어지면 바로 탈출
                        target = minNum
                        break
                    } else if (target + smallerNums[i] < minNum) {
                        // 더했는데도 숫자가 아직 작으면 앞으로 더 더해
                        target += smallerNums[i]
                    }
                }

                // 끝까지 다 더했는데도 숫자가 안만들어지면 이게 정담
                if (target != minNum) loop = false
                minNum += 1
            }
            // 마지막에 +1 했으니 정답은 -1한 값
            return minNum - 1
        }

        private fun answer(n: Int, data: List<Int>): Int {
            val input = data.sorted()
            //11239
            var target = 1
            run {
                input.forEach {
                    // 만들 수 없는 금액일 때 탈출
                    if (target < it) {
                        return@run
                    }
                    target += it
                }
            }
            return target
        }
    }
}