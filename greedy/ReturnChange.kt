package greedy

class ReturnChange {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val coinType = mutableListOf(500, 100, 50, 10)
            val result = calculateExchange(1260, coinType)
            println(result)
        }

        private fun calculateExchange(n: Int, coinType: MutableList<Int>): Int {
            var amount = n
            var count = 0
            coinType.forEach {
                count += amount / it
                amount %= it
            }
            return count
        }
    }
}