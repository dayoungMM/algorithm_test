package dfsbfs

import java.util.*


class PopulationTransfer {
    companion object{
        internal class Position(val x: Int, val y: Int)
        //global variable
        var n = 0
        var l = 0
        var r = 0
        var totalCount = 0

        var graph = Array(50) { IntArray(50) }
        var unions = Array(50) { IntArray(50) }
        var dx = intArrayOf(-1, 0, 1, 0)
        var dy = intArrayOf(0, -1, 0, 1)


        fun process(x: Int, y: Int, index: Int) {

            var x = x
            var y = y
            val united = ArrayList<Position>()
            united.add(Position(x, y))
            //bfs
            val q: Queue<Position> = LinkedList()
            q.offer(Position(x, y))
            unions[x][y] = index // 현재 연합의 번호 할당
            var summary = graph[x][y]
            var count = 1 // 현재 연합의 국가 수

            while (!q.isEmpty()) {
                val pos = q.poll()
                x = pos.x
                y = pos.y
                //상하좌우
                for (i in 0..3) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    // 바로 옆에 있는 나라를 확인하여
                    if (0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
                        // 옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
                        val gap = Math.abs(graph[nx][ny] - graph[x][y])
                        if (l <= gap && gap <= r) {
                            q.offer(Position(nx, ny))

                            unions[nx][ny] = index
                            summary += graph[nx][ny]
                            count += 1
                            united.add(Position(nx, ny))
                        }
                    }
                }
            }
            // 연합 국가끼리 인구를 분배
            for (i in united.indices) {
                x = united[i].x
                y = united[i].y
                graph[x][y] = summary / count
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val sc = Scanner(System.`in`)
            n = sc.nextInt()
            l = sc.nextInt()
            r = sc.nextInt()
            for (i in 0 until n) {
                for (j in 0 until n) {
                    graph[i][j] = sc.nextInt()
                }
            }


            while (true) {
                for (i in 0 until n) {
                    for (j in 0 until n) {
                        unions[i][j] = -1
                    }
                }
                var index = 0
                for (i in 0 until n) {
                    for (j in 0 until n) {
                        if (unions[i][j] == -1) { // 해당 나라가 아직 처리되지 않았다면
                            process(i, j, index)
                            index += 1
                        }
                    }
                }

                if (index == n * n) break
                totalCount += 1
            }


            println(totalCount)
        }
    }
}




