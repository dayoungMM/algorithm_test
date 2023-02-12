package implement

class Build {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var buildFrame = arrayOf(intArrayOf(1,0,0,1), intArrayOf(1,1,1,1), intArrayOf(2,1,0,1), intArrayOf(2,2,1,1), intArrayOf(5,0,0,1),
                intArrayOf(5,1,0,1), intArrayOf(4,2,1,1), intArrayOf(3,2,1,1))
            println(solution(5, buildFrame))

            buildFrame = arrayOf(intArrayOf(0,0,0,1), intArrayOf(2, 0, 0, 1), intArrayOf(4, 0, 0, 1), intArrayOf(0, 1, 1, 1), intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 1, 1, 1), intArrayOf(3, 1, 1, 1), intArrayOf(2, 0, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(2, 2, 0, 1)
            )
            println(solution(5, buildFrame))
        }
        // check 구현이 어려워 답안 보고 작성
        fun check(answer: MutableList<IntArray>): Boolean {
            for (i in answer.indices) {
                val x = answer[i][0]
                val y = answer[i][1]
                val stuff = answer[i][2]
                if (answer.contains(intArrayOf(x,y,stuff))) {
                    return false
                }
                when (stuff) {
                    0 -> {
                        // 기둥은 바닥 위에 있거나, 보의 한쪽 끝 부분 위에 있거나, 다릉 기둥 위에 있어야함
                        if ((y == 0) || (answer.contains(intArrayOf(x-1, y, 1)) || (answer.contains(intArrayOf(x,y,1)) || (answer.contains(intArrayOf(x, y-1, 0)))))) {

                        }else {
                            return false
                        }
                    }
                    else -> {
                        // 한쪽 끝부분이 기둥 위, 양쪽 끝부분이 다른 보와 동시에 연결되어있어야함
                        if (answer.contains(intArrayOf(x,y-1, 0)) || answer.contains(intArrayOf(x+1,y-1, 0)) || answer.contains(intArrayOf(x-1,y, 1)) || answer.contains(intArrayOf(x+1,y, 1))) {

                        } else {
                            return false
                        }
                    }
                }
            }
            return true
        }
        fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
            var answer = mutableListOf<IntArray>()
            for (i in build_frame.indices) {
                val x = build_frame[i][0]
                val y = build_frame[i][1]
                val stuff = build_frame[i][2]
                val operate = build_frame[i][3]
                if (operate == 0) {
                    //삭제
                    answer.remove(intArrayOf(x, y, stuff))
                    if (!check(answer)) {
                        //삭제 취소
                        answer.add(intArrayOf(x, y, stuff))
                    }
                } else {
                    // 추가
                    answer.add(intArrayOf(x,y,stuff))
                    if (!check(answer)) {
                        //추가 취소
                        answer.remove(intArrayOf(x,y,stuff))
                    }
                }
            }
            return answer.sortedWith(compareBy<IntArray> {it[0]}.thenBy { it[1] }.thenBy { it[2] }).toTypedArray()
        }
    }
}