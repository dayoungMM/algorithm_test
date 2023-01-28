package greedy

class UntilOne {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val (n, k) = readln().split(" ").let { Pair (it[0].toInt(), it[1].toInt()) }
            var result = 0
            var nRest = n
            while (nRest > 1) {
                if (nRest % k == 0) {
                    nRest /= k
                }else {
                    nRest -= 1
                }
                result += 1
            }

            println(result)
        }
    }
}