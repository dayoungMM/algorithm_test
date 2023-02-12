package implement

class Snake {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val n = readln().toInt()
            val k = readln().toInt()
            val matrix = Array(n+1) { IntArray(n+1) }
            var data = mutableListOf<Pair<Int, String>>()

            for (i in 0 until k) {
                val (row, col) = readln().split(" ").let {
                    Pair(it[0].toInt(), it[1].toInt())
                }
                matrix[row][col] = 1
            }

            val d = readln().toInt()
            for (i in  0 until d) {
                readln().split(" ").also {
                    data.add(Pair(it[0].toInt(), it[1]))
                }
            }

            // 동, 남, 서, 북
            val rowDirection = mutableListOf<Int>(0, 1, 0, -1)
            val colDirection = mutableListOf<Int>(1, 0, -1, 0 )


            //init
            var row = 1
            var col = 1
            matrix[row][col] = 2
            var directionIndex = 0
            var time = 0
            var index = 0
            var q = mutableListOf(Pair (row, col))
            while (true) {
                val newRow = row + rowDirection[directionIndex]
                val newCol = col + colDirection[directionIndex]
                if ((newRow >=1) && (newRow <= n) && (newCol >=1) && (newCol <= n) && (matrix[newRow][newCol] != 2)) {
                    // 사과가 없다면 꼬리제거
                    if (matrix[newRow][newCol] == 0) {
                        // 머리 이동
                        matrix[newRow][newCol] = 2
                        q.add(Pair(newRow, newCol))
                        val (x, y) = q.removeFirst()
                        // 꼬리제거
                        matrix[x][y] = 0
                    }else if (matrix[newRow][newCol] == 1) {
                        //꼬리 제거 안함
                        matrix[newRow][newCol] = 2
                        q.add(Pair(newRow, newCol))
                    }
                } else {
                    time += 1
                    break
                }
                time += 1
                row = newRow
                col = newCol
                // 회전
                if (index < d && time == data[index].first ) {
                    directionIndex = turn(directionIndex, data[index].second)
                    index += 1
                }

            }
//            println(">>>answer>>>>")
            println(time)

        }

        fun turn(directionIndex:Int, side: String): Int {
            return when (side) {
                "L" -> if (directionIndex == 0) 3 else directionIndex -1
                else -> (directionIndex +1) % 4
            }
        }
    }
}