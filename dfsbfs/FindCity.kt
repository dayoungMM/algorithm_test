package dfsbfs

class FindCity {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            //도시개수, 도로개수, 최단거리(조건), 출발지
            val (n, m, k, x) = readln().split(" ").map { it.toInt() }
            //1부터 시작해서 n+1 사이즈
            // 각 행번호: 출발도시, 각 행에는 인접 도시 add
            val graph = Array(n+1){ mutableListOf<Int>() }
            for (i in 1..m){
                val (a, b) = readln().split(" ").map { it.toInt() }
                graph[a].add(b)
            }
            //최단거리 측정
            val distances = IntArray(n+1){-1}
            // 출발도시 자기 자신
            distances[x] = 0

            val queue = ArrayDeque<Int>()
            queue.add(x)
            while (queue.size > 0){
                val current = queue.removeFirst()
                val neighbors = graph[current]
                neighbors.forEach {
                    if (distances[it] == -1){
                        //미방문 도시라면 X로부터 current까지의 거리 _+1
                        distances[it]= distances[current] +1
                        queue.add(it)
                    }
                }
            }

            //k 거리 다 확인
            var empty = true
            for (i in 1 until n+1){
                if (distances[i] == k){
                    println(i)
                    empty = false
                }
            }
            if (empty == true){
                println(-1)
            }
        }
    }
}