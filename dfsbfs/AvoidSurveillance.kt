package dfsbfs

import java.util.*


class AvoidSurveillance {
    companion object {
        internal class Combination(private val n: Int, private val r: Int) {
            private val now : IntArray
            private val result : ArrayList<ArrayList<Position>>

            fun getResult(): ArrayList<ArrayList<Position>> {
                return result
            }

            init {
                now = IntArray(r)
                result = ArrayList<ArrayList<Position>>()
            }

            fun combination(arr: MutableList<Position>, depth: Int, index: Int, target: Int) {
                if (depth == r) {
                    val temp: ArrayList<Position> = ArrayList<Position>()
                    for (i in now.indices) {
                        temp.add(arr[now[i]])
                    }
                    result.add(temp)
                    return
                }
                if (target == n) return
                now[index] = target
                combination(arr, depth + 1, index + 1, target + 1)
                combination(arr, depth, index, target + 1)
            }
        }

        internal data class Position(
            var x: Int,
            var y: Int
        )
        @JvmStatic
        fun main(args: Array<String>) {
            val n = readln().toInt()
            val graph = Array(n) { CharArray(n) }
            val teacherPosition = mutableListOf<Position>()
            val spaces = mutableListOf<Position>()
            for (i in 0 until n) {
                val row = readln().split(" ").map { it.toCharArray()[0] }
                for (j in 0 until n) {
                    graph[i][j] = row[j]
                    if (row[j] == 'T') {
                        teacherPosition.add(Position(i, j))
                    } else if (row[j] == 'X') {
                        spaces.add(Position(i, j))
                    }
                }
            }

            // 특정 방향으로 감시를 진행 (학생 발견: true, 학생 미발견: false)
            fun watch(x: Int, y: Int, direction: Int): Boolean {
                // 왼쪽 방향으로 감시
                var x = x
                var y = y
                if (direction == 0) {
                    while (y >= 0) {
                        if (graph[x][y] == 'S') {
                            return true
                        }
                        if (graph[x][y] == 'O') {
                            return false
                        }
                        y -= 1
                    }
                }
                // 오른쪽 방향으로 감시
                if (direction == 1) {
                    while (y < n) {
                        if (graph[x][y] == 'S') {
                            return true
                        }
                        if (graph[x][y] == 'O') {
                            return false
                        }
                        y += 1
                    }
                }
                // 위쪽 방향으로 감시
                if (direction == 2) {
                    while (x >= 0) {
                        if (graph[x][y] == 'S') {
                            return true
                        }
                        if (graph[x][y] == 'O') {
                            return false
                        }
                        x -= 1
                    }
                }
                // 아래쪽 방향으로 감시
                if (direction == 3) {
                    while (x < n) {
                        if (graph[x][y] == 'S') {
                            return true
                        }
                        if (graph[x][y] == 'O') {
                            return false
                        }
                        x += 1
                    }
                }
                return false
            }

            fun checkStudents(): Boolean {
                // 모든 선생의 위치를 하나씩 확인
                for (i in 0 until teacherPosition.size) {
                    val x: Int = teacherPosition[i].x
                    val y: Int = teacherPosition[i].y
                    // 4가지 방향으로 학생을 감지할 수 있는지 확인
                    for (j in 0..3) {
                        if (watch(x, y, j)) {
                            return true
                        }
                    }
                }
                return false
            }

            // 빈 공간에서 3개를 뽑는 모든 조합을 확인
            val comb = Combination(spaces.size, 3)
            comb.combination(spaces, 0, 0, 0)
            val spaceList = comb.getResult()

            // 학생이 한 명도 감지되지 않도록 설치할 수 있는지의 여부
            var found = false
            for (i in spaceList.indices) {
                // 장애물들을 설치해보기
                for (j in spaceList[i].indices) {
                    val x: Int = spaceList[i][j].x
                    val y: Int = spaceList[i][j].y
                    graph[x][y] = 'O'
                }
                // 학생이 한 명도 감지되지 않는 경우
                if (!checkStudents()) {
                    // 원하는 경우를 발견한 것임
                    found = true
                    break
                }
                // 설치된 장애물을 다시 없애기
                for (j in spaceList[i].indices) {
                    val x: Int = spaceList[i][j].x
                    val y: Int = spaceList[i][j].y
                    graph[x][y] = 'X'
                }
            }
            if (found) println("YES") else println("NO")
        }
    }

}





