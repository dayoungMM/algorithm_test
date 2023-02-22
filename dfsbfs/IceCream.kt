package dfsbfs

class IceCream {
    companion object{
        lateinit var arr: Array<IntArray>
        var result = 0

        @JvmStatic
        fun main(args: Array<String>) {
            val (n, m) = readln().split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
            arr = Array(n){IntArray(m)}
            for (i in 0 until n){
                val row = readln().split("").slice(1..m).map { it.toInt() }.toIntArray()
                arr[i] = row
            }
            for (i in 0 until n){
                for (j in 0 until m){
                    //밟지 않은 새 땅이고 dfs로 끝까지 다 탐색했다면 result +=1
                    if (dfs(i, j, n, m)) result+=1
                }
            }

            println(result)
        }

        fun dfs(x:Int, y:Int, n:Int, m:Int):Boolean{
            // 이미 방문했을경우 false
            if (arr[x][y] == 1){
                return false
            }
            val turn = arrayListOf<Pair<Int,Int>>(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))
            //방문 안했다면 방문으로 변경
            arr[x][y] = 1
            // 상하좌우 살펴봐서 이동할게 없다면 result +=1, 이동할게 있다면 이동해
            turn.forEach{
                if (x+it.first>=0 && x+it.first < n && y+it.second >=0 && y+it.second <m ){
                    dfs(x+it.first, y+it.second, n, m)
                }
            }
            //상하좌우 끝났으면 종료
            return true

        }
    }
}