package dfsbfs

import java.util.*

class Hanoi {
    companion object{


        val sb = StringBuilder()
        var cnt = 0


        @JvmStatic
        fun main(args: Array<String>) {
            val k = readln().toInt()
            hanoi(k, 1, 3, 2)
            println(cnt)
            println(sb)
        }

        fun move(from:Int, to:Int){
            //원판 이동
            sb.append("$from $to\n")
            cnt += 1
        }
        fun hanoi(n: Int, from: Int, to: Int, temp: Int) {
            if (n == 1) {
                move (from, to)
                return
            }
            // 임시 기둥에 n-1까지 옮겨놓고 (재귀)
            hanoi(n-1, from, temp, to)
            //to에 제일 큰거 놓고
            move(from, to)
            //나머지 옮기기 (재귀)
            hanoi(n-1, temp, to, from)
        }
    }
}

///각 기둥을 stack으로 만들어 접근했으나, 어디에서 어디로 이동했는지만 표시하면 되기 때문에 기둥 Index를 from, to, temp의 파라미터로 사용
//mutableList보다 StringBuilder 사용하여 효율성 테스트 통과