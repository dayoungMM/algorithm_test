package dfsbfs


class Josephus {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val (N, K) = readln().split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
            val q = mutableListOf<Int>()
            var idx = 0
            var result = mutableListOf<Int>()
            for (i in 1..N){
                q.add(i)
            }
            while (q.size > 0){
                idx += K-1
                idx %= q.size
                result.add(q[idx])
                q.removeAt(idx)

            }
            println("<${result.joinToString ( ", " )}>")
        }
    }
}