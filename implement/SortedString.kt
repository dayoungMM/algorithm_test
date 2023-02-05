package implement

import java.util.PriorityQueue

class SortedString {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val input = "K1KA5CB7"
//            println(mySolution(input))
            println(mySolution(input))
            require(mySolution(input) == "ABCKK13")
            println(answer(input))
            require(answer(input) == "ABCKK13")
            println(mySolution("AJKDLSI412K4JSJ9D"))
            require(mySolution("AJKDLSI412K4JSJ9D") == "ADDIJJJKKLSS20")
            require(answer("AJKDLSI412K4JSJ9D") == "ADDIJJJKKLSS20")
        }

        fun mySolution(input: String): String {
            var numSum = 0
            val q = PriorityQueue<Char>( )
            var result = String()
            for (i in 0 until input.length) {
                // 숫자는 48~57 , 문자는 65 ~ 122
                val ascii = input[i].code
                if (ascii < 58) {
                    numSum += (ascii - '0'.code)
                } else {
                    q.add(input[i])
                }
            }

            while (q.isNotEmpty()) {
                result += q.poll()
            }
            if (numSum >0) {
                return result + numSum.toString()
            }
            return result
        }

        fun answer(input: String): String{
            val alphabets = mutableListOf<Char>()
            var numSum = 0

            input.forEach {
                if (it.isLetter()) {
                    alphabets.add(it)
                } else {
                    // 숫자의 경우 ascii코드 - 0의 ascii code를 해주면 toInt 한 결과와 동일하다
                    numSum += (it.code - '0'.code)
                }

            }
            val sortedAlpha = alphabets.sorted().joinToString ("" )
            if (numSum > 0 ) {
                return sortedAlpha + numSum.toString()
            } else {
                return sortedAlpha
            }

        }
    }
}