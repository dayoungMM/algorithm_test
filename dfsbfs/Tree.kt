package dfsbfs

class Tree {
    companion object {
        lateinit var answer: Array<Array<String>>

        @JvmStatic
        fun main(args: Array<String>) {
            val n = 24
            answer = Array(n) { Array<String>(2 * n) {" "} }
            star(0, n-1, n)
            answer.forEach {
                println(it.joinToString(""))
            }

        }

        fun star(x:Int, y:Int, n:Int) {
            if (n == 3){
                //가장 작은 단위듸 나무 찍기
                answer[x][y] = "*"
                answer[x + 1][y - 1] = "*"
                answer[x + 1][y + 1] = "*"
                answer[x + 2][y - 2] = "*"
                answer[x + 2][y - 1] = "*"
                answer[x + 2][y] = "*"
                answer[x + 2][y + 1] = "*"
                answer[x + 2][y + 2] = "*"
                return
            } else {
                //재귀
                val newN = n/2
                //top
                star(x,y,newN)
                //bottom left
                star(x+newN, y-newN, newN)
                //botteom right
                star(x+newN, y+newN, newN)
            }

        }

    }
}