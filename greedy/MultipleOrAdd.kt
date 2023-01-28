package greedy

class MultipleOrAdd {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val input = readln().map { it.toString().toInt() }
            println(mysolution(input))

        }
        private fun mysolution(data: List<Int>):Int {
            var result = 0
            data.forEach {
                if (it <= 1 || result <= 1) {
                    result += it
                } else {
                    result *= it
                }
            }
            return result
        }
    }
}