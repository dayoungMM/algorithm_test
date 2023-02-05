package implement

class LuckyStraight {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val input = readln()
            mySolution(input)
            answer(input)
        }

        fun mySolution(input:String) {
            val count = input.length / 2
            var left = 0
            var right = 0
            for (i in 0 until count){
                left += input[i].toString().toInt()
                right += input[input.length -1 -i].toString().toInt()
            }
            if (left == right) println("LUCKY") else println("READY")
        }

        fun answer(input: String) {
            val length = input.length
            var summary = 0
            for (i in 0 until length / 2) {
                summary += input[i].toString().toInt()
            }
            for (i in length /2 until input.length) {
                summary -= input[i].toString().toInt()
            }
            if (summary == 0) println("LUCKY") else println("READY")
        }
    }

}