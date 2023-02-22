package dfsbfs

class BfsBasic {
    companion object{
        val answer = mutableListOf<Int>()
        @JvmStatic
        fun main(args: Array<String>) {
            val graph = mutableListOf<MutableList<Int>>()
            graph.add(mutableListOf())
            graph.add(mutableListOf(2, 3, 8))
            graph.add(mutableListOf(1, 7))
            graph.add(mutableListOf(1, 4, 5))
            graph.add(mutableListOf(3, 5))
            graph.add(mutableListOf(3, 4))
            graph.add(mutableListOf(7))
            graph.add(mutableListOf(2, 6, 8))
            graph.add(mutableListOf(1, 7))
            //노드 방문 여부
            var visited = Array(9) { false }
            bfs(graph,1,visited)

        }

        fun bfs(graph:MutableList<MutableList<Int>>, current:Int, visited:Array<Boolean>){
            //큐
            val q = mutableListOf<Int>()
            // 현재 위치 추가
            q.add(current)

            // 방문처리
            visited[current] = true
            //큐가 빌 때 까지 반복
            while (q.size>0){
                //큐에서 하나 꺼냄
                val num = q[0].also { q.removeAt(0) }
                answer.add(num)
                //해당 노드의 인접한 노드 다 방문
                graph[num].forEach {
                    //방문하지 않은노드라면
                    if (!visited[it]){
                        //큐에 다 넣고 탐색
                        q.add(it)
                        visited[it] = true
                    }
                }
            }
            println(answer)

        }
    }
}