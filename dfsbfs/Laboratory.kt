package dfsbfs

class Laboratory {
    // 벽 설치하는 조건에 대해서 아이디어가 생각나지 않아 답보고 함
    // 어차피 안퍼지게 하려면 퍼지는 진원지로부터 가까운곳에 설치해야하므로 dfs 하면서 바로바로 설치
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val (n, m) = readln().split(" ").map { it.toInt() }
            // 맵 초반 그래프
            val initGraph = Array(n){IntArray(m)}
            // 벽 설치 이후 그래프
            val finalGraph = Array(n){IntArray(m)}
            for (i in 0 until n){
                val row = readln().split(" ").map { it.toInt() }
                for (j in 0 until m){
                    initGraph[i][j] = row[j]
                }
            }
            val turn = arrayListOf<Pair<Int,Int>>(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))
            var result = 0

            //바이러스 퍼지기 시뮬레이션
            fun virus(x: Int, y:Int){
                turn.forEach{
                    val nx = it.first
                    val ny = it.second
                    if (nx >=0 && nx < n && ny>=0 && ny < m){
                        // 미감염일 경우 감염시킴
                        if (finalGraph[nx][ny] == 0) {
                            finalGraph[nx][ny] = 2
                            virus(nx, ny)
                        }
                    }
                }
            }

            //안전영역 계산
            fun countSafeZone():Int{
                var score = 0
                for (i in 0 until n){
                    for (j in 0 until m){
                        if (finalGraph[i][j] == 0){
                            score += 1
                        }
                    }
                }
                return score
            }

            // 울타리 설치하면서 안전영역 계산 (울타리 최대 설치개수: count)
            fun dfs(count: Int){
                //울타리 3개 설치되면 안전영역 계산
                if (count ==1){
                    //복사
                    for (i in 0 until n){
                        for (j in 0 until m){
                            finalGraph[i][j] = initGraph[i][j]
                        }
                    }
                    // 전파
                    for (i in 0 until n){
                        for (j in 0 until m){
                            if (finalGraph[i][j] == 2){
                                virus(i, j)
                            }
                        }
                    }
                    // 안전영역 계산
                    val safeCnt = countSafeZone()
                    result = if (safeCnt > result) safeCnt else result
                    // 이거 빠트리면 무한반복
                    return
                }
                //울타리 3개 설치안되면 울타리 설치
                for (i in 0 until n){
                    for (j in 0 until m){
                        if (initGraph[i][j] == 0){
                            //빈공간이면
                            //울타리 설치
                            initGraph[i][j] = 1
                            //울타리 3개 설치될때까지 dfs (depth 3이 되어야 재귀 끝난다는 뜻)

                            dfs(count+1)
                            //계산후 다시 울타리 철거
                            initGraph[i][j] = 0
                        }
                    }
                }
            }
            dfs(0)
            println(result)
        }
    }
}