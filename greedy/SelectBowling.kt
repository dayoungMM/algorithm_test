package greedy

class SelectBowling {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val (n, m) = readln().split(" ").map { it.toInt() }
            val countList = mutableListOf<Int>()
            for (i in 0 until m) {
                countList.add(0)
            }
            val balls = readln().split(" ").map {
                it.toInt().also {
                    countList[it-1] += 1
                }
            }

//            println(mysolution(countList, balls, m))
            println(answer(countList, balls, m, n))

        }

        private fun mysolution(cntList: MutableList<Int>, balls:List<Int>, m: Int): Int {
            var countList = cntList
            var result = 0
            // index0부터 선택, 다른 무게들 공의 갯수의 합
            balls.forEach {
                // 나랑 다른 무게 공 개수의 합
                var tempSump = 0
                for (i in 0 until m) {
                    if (i+1 != it) {
                        tempSump += countList[i]
                    }
                }
                result += tempSump
                // 내 무게의 공 개수 하나 줄이기
                countList[it-1] -=1
            }
            return result
        }

        private fun answer(cntList: MutableList<Int>, balls: List<Int>, m:Int, n:Int):Int {
            var totalLen = n
            var countList = cntList
            var result = 0
            for (i in 0 until m) {
                totalLen -= cntList[i]
                //A가 고른 개수 * B가 고를 수 있는 개수
                result += cntList[i] * totalLen
            }
            return result
        }
    }
}