package implement

import java.lang.RuntimeException

class Game {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var (N,M) = Pair(4, 4)
            var (row, col, dir) = Triple(1, 1, 0)
            // 북, 동, 남, 서
            val directions = mutableListOf<Pair<Int,Int>>(Pair(-1, 0), Pair(0,-1), Pair(1,0), Pair(0,1))
            // 1: 바다, 0: 육지
            val maps: List<MutableList<String>> = mutableListOf<String>("1 1 1 1", "1 0 0 1", "1 1 0 1", "1 1 1 1").map { it.split(" ").toMutableList() }

            val (moveRow, moveCol) = directions[(dir) % directions.size]
            // 네방향 카운트
            var turn = 0
            var answer = 0
            while (true) {
                //방문처리
                maps[row][col] = "1"
                dir = (dir+1) % directions.size
                val newRow = row + moveRow
                val newCol = col + moveCol
                if ( newRow< 0 && newRow >= N && newCol < 0 && newCol >= M) {
                    turn += 1
                    continue
                }

                if (maps[newRow][newCol] == "0") {
                    row = newRow
                    col = newCol
                    // 이미 가본칸 표시
                    maps[newRow][newCol] = "2"
                    turn = 0
                    answer += 1
                    continue
                }

                if (turn == 4) {
                    val back = dir.let {
                        directions[(it +1) % directions.size]
                    }
                    if (maps[back.first][back.second] == "1") {
                        //바다인경우 stop
                        break
                    } else {
                        // 육지인경우 go
                        row = newRow
                        col = newCol
                        turn = 0
                        answer += 1
                        continue
                    }
                }

                turn += 1
            }

            print("$row, $col")
            assert(answer == 3)

        }
    }
}