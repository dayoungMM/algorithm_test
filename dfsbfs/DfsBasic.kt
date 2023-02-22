package dfsbfs

class DfsBasic {
    companion object {

        //큐
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
            dfs(graph, 1, visited = visited)
            println(answer)

        }

        fun dfs(graph: MutableList<MutableList<Int>>, current: Int, visited: Array<Boolean>) {
            // 방문한 순서
            answer.add(current)

            //방문처리
            visited[current] = true
            // 현재 노드와 연결되어있는 노드를 재귀적으로 방문
            graph[current].forEach {
                if (!visited[it]) {
                    //미방문인경우
                    dfs(graph, it, visited)
                }

            }
        }
    }
}