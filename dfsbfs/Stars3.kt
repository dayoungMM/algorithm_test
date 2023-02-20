package dfsbfs

import kotlin.math.pow

class Stars3 {
    companion object {
        lateinit var answer : Array<Array<String>>

        @JvmStatic
        fun main(args: Array<String>) {
            val n = readln().toInt()
            answer = Array(verticalLen(n)){Array(horizontalLen(n)) {" "} }
            if (n%2 == 0){
                star(0,0,n)
            }else {
                star(verticalLen(n)-1, 0, n)
            }
            answer.forEach {
                println(it.joinToString(""))
            }

        }

        fun star(x:Int, y:Int, n:Int) {
            val vlen = verticalLen(n)
            val hlen = horizontalLen(n)

            if (n == 1) {
                answer[x][y] = "*"
                return
            } else if (n % 2 == 0) {
                //역삼각형
                //윗변
                for (j in y until y+horizontalLen(n)) {
                    answer[x][j] = "*"
                }
                //꼭지점
                answer[x+ verticalLen(n) -1][y+ horizontalLen(n) /2 ] = "*"
                //빗변
                for (i in 1 until verticalLen(n)-1) {
                    answer[x+i][y+i] = "*"
                    answer[x+i][y+ horizontalLen(n) - i -1] = "*"
                }
                star(x + verticalLen(n)/2, y+ verticalLen(n)/2 + 1, n-1)
            } else {
                //정삼각형
                //밑변
                for (j in y until y+ horizontalLen(n)) {
                    answer[x][j] = "*"
                }
                //꼭지점
                answer[x- verticalLen(n)+1][y + horizontalLen(n)/2] = "*"
                // 빗변
                for (i in 1 until verticalLen(n)-1) {
                    answer[x-i][y+ horizontalLen(n) -i-1] = "*"
                    answer[x-i][y+i] = "*"
                }
                star(x- verticalLen(n)/2-1, y+ verticalLen(n)/2 +1, n-1)
            }
        }

        fun verticalLen(n:Int): Int {
            return ((2.0).pow(n) -1).toInt()
        }
        fun horizontalLen(n:Int): Int {
            return ((2.0).pow(n+1) -3).toInt()
        }
    }
}

//n이 짝수일 때 역삼각형
//n이 홀수일 때 정삼각형
// 윗변/밑변의 개수: 2^n -1
// 빗변의 개수: 2^(n+1) -3
//import kotlin.math.*
//틀렸는데 어디를 더 고쳐야할지 모르겠음