package dfsbfs

import java.util.*


internal class Virus(val index: Int, val second: Int, val x: Int, val y: Int) : Comparable<Virus?> {

    // 정렬 기준은 '번호가 낮은 순서'
    override fun compareTo(other: Virus?): Int {
        return if (index < other!!.index) {
            -1
        } else 1
    }
}

object Main {
    var n = 0
    var k = 0

    // 전체 보드 정보를 담는 배열
    private var graph = Array(200) { IntArray(200) }
    private var viruses = ArrayList<Virus>()

    // 바이러스가 퍼져나갈 수 있는 4가지의 위치
    private var dx = intArrayOf(-1, 0, 1, 0)
    private var dy = intArrayOf(0, 1, 0, -1)
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        k = sc.nextInt()
        for (i in 0 until n) {
            for (j in 0 until n) {
                graph[i][j] = sc.nextInt()
                // 해당 위치에 바이러스가 존재하는 경우
                if (graph[i][j] != 0) {
                    // (바이러스 종류, 시간, 위치 X, 위치 Y) 삽입
                    viruses.add(Virus(graph[i][j], 0, i, j))
                }
            }
        }

        // 정렬 이후에 큐로 옮기기 (낮은 번호의 바이러스가 먼저 증식하므로)
        Collections.sort(viruses)
        val q: Queue<Virus> = LinkedList()
        for (i in viruses.indices) {
            q.offer(viruses[i])
        }
        val targetS: Int = sc.nextInt()
        val targetX: Int = sc.nextInt()
        val targetY: Int = sc.nextInt()

        // 너비 우선 탐색(BFS) 진행
        while (!q.isEmpty()) {
            val virus = q.poll()
            // 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
            if (virus.second == targetS) break
            // 현재 노드에서 주변 4가지 위치를 각각 확인
            for (i in 0..3) {
                val nx = virus.x + dx[i]
                val ny = virus.y + dy[i]
                // 해당 위치로 이동할 수 있는 경우
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.index
                        q.offer(Virus(virus.index, virus.second + 1, nx, ny))
                    }
                }
            }
        }
        println(graph[targetX - 1][targetY - 1])
    }
}