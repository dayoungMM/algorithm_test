package implement

class Knight {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val input = "a1".split("").subList(1,3)
            val cols = mutableListOf<String>("a","b","c","d","e","f","g","h")
            val col = cols.indexOf(input[0]) +1
            val row = input[1].toInt()
            val step = mutableListOf<Pair<Int,Int>>(Pair(2,1), Pair(2,-1), Pair(-2,1), Pair(-2,-1), Pair(1,2), Pair(1,-2), Pair(-1,2), Pair(-1,-2))
            var answer = 0
            step.forEach {
                val newR = row + it.first
                val newC = col + it.second
                // 움직일 수 있는 칸이 있으면 경우의 수에 추가
                if (newR >=1 && newR <=8 && newC >=1 && newC <= 8) {
                    answer += 1
                }
            }
            assert(answer == 2)
        }
    }
}