package implement

class UpDownLeftRight {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (row, col) = solution(5, mutableListOf<String>("R","R","R","U","D","D"))
            assert( row == 3 && col == 4)
        }

        fun solution(n: Int, directions: MutableList<String>): Pair<Int, Int> {
            var row = 1
            var col = 1
            directions.forEach {
                when (it) {
                    "L" -> if (col >= 2) col -= 1
                    "R" -> if (col <= n - 1) col += 1
                    "U" -> if (row >= 2) row -=1
                    "D" -> if (row <= n - 1) row += 1
                }
            }
            return Pair(row, col)
        }
    }
}