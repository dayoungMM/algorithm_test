package greedy

class NumberCardGame {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = readln().split(" ")
            val n = input[0].toInt()
            val m = input[1].toInt()
            val data = mutableListOf<Int>()
            for (i in 1..n) {
                var rowMin = 10000
                readln().split(" ").map {
                    if (it.toInt() < rowMin) {
                        rowMin = it.toInt()
                    }
                }
                data.add(rowMin)
            }
            println(data.max())
        }
    }
}