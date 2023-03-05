package dfsbfs

import kotlin.math.max

class Infection {
    companion object{
        internal data class Virus(val virusNum: Int, val second: Int, val x: Int, val y: Int)
        @JvmStatic
        fun main(args: Array<String>) {
            val (n, k) = readln().split(" ").map { it.toInt() }
            val graph = Array(n+1){IntArray(n+1)}
            // 바이러스 시작점
            val startPosition = Array(k+1){ Pair(0,0) }
            for (i in 1 until n+1){
                val row = readln().split(" ").map { it.toInt() }
                for (j in 1 until n+1){
                    val virus = row[j-1]
                    graph[i][j] = virus
                    if (virus != 0){
                        startPosition[virus] = Pair(i, j)
                    }
                }
            }
            val (s, targetX, targetY) = readln().split(" ").map { it.toInt() }
            // 순서대로 넣기 (x, y, value)
            val totalQueue = ArrayDeque<Virus>()

            for (i in 1 until k+1){
                totalQueue.add(Virus(i, 0, startPosition[i].first, startPosition[i].second))
            }
            var totalTime = 0

            fun bfs() {
                val turn = arrayListOf<Pair<Int,Int>>(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))
                while(totalQueue.isNotEmpty()){
                    if (totalTime == s) break
                    val (virusNum, sec, x, y) = totalQueue.removeFirst()
                    totalTime = max(totalTime, sec)
                    turn.forEach {
                        val nx = x + it.first
                        val ny = y + it.second
                        if (nx >=1 && nx <=n && ny >=1 && ny <=n){
                            if (graph[nx][ny] == 0){
                                graph[nx][ny] = virusNum
                                totalQueue.add(Virus(virusNum, sec+1, nx, ny))
                            }
                        }
                    }

                }
            }
            bfs()
            println(graph[targetX][targetY])
        }
    }
}