package dfsbfs

import java.util.Queue

class Maze {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val (n, m) = readln().split(" ").map { it.toInt() }
            val graph = Array(n){IntArray(m)}
            for (i in 0 until n){
                val row = readln().split("").slice(1 ..m).map{it.toInt()}
                for (j in 0 until m){
                    graph[i][j] = row[j]
                }
            }
            println(bfs(0,0, n, m, graph))
        }

        fun bfs(x:Int, y:Int, n:Int, m:Int, graph:Array<IntArray>): Int {
            val queue = ArrayDeque<Pair<Int,Int>>()
            queue.add(Pair(x,y))
            while (true){
                val (a,b) = queue.removeFirst()
                val turn = arrayListOf<Pair<Int,Int>>(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))
                //네방향 위치 확인
                turn.forEach{
                    val nx = a+it.first
                    val ny = b+it.second
                    if (nx>=0 && nx < n && ny >=0 && ny <m && graph[nx][ny] == 1){
                        // 이전 경로 값 +1
                        graph[nx][ny] = graph[a][b] + 1
                        queue.add(Pair(nx, ny))
                    }
                }
                if (queue.size <= 0) break
            }
            //마지막값
            return graph[n-1][m-1]
        }
    }
}