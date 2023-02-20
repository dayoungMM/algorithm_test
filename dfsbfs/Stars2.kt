package dfsbfs

class Stars2 {
    companion object{
        lateinit var answer : Array<Array<String>>

        @JvmStatic
        fun main(args: Array<String>) {
            val n = readln().toInt()
            //4씩 증가
            val len = 1+ 4*(n-1)
            answer = Array(len){Array(len){" "} }
            star(0, 0, n)
            answer.forEach {
                println(it.joinToString (""))
            }

        }

        fun star(x:Int, y:Int, n:Int){
            if (n == 1) {
                answer[x][y] = "*"
                return
            }
            val len = 1+ 4*(n-1)
            //위 아래 선
            for (j in y until y+len) {
                answer[x][j] = "*"
                answer[x + len - 1][j] = "*"
            }
            // 좌우 양옆 선
            for (i in x until x+len) {
                answer[i][y] = "*"
                answer[i][y + len - 1] = "*"
            }

            //재귀
            star(x+2, y+2, n-1)
        }
    }
}