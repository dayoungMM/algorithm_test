package dfsbfs

import java.util.*

class OpenClosed {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            while (true){
                val input = readln()
                if (input == ".") {
                    break
                }
                println(check(input))
            }


        }
        fun check(str: String): String {
            val tempStack = Stack<String>()
            val closeMap = hashMapOf<String,String>("[" to "]", "(" to ")")
            str.forEach {
                if (closeMap.keys.contains(it.toString())) {
                    tempStack.push(it.toString())
                } else if (closeMap.values.contains(it.toString())) {
                    if (tempStack.isEmpty()) return "no"
                    val open = tempStack.pop()
                    if (closeMap[open] != it.toString()) return "no"
                }
            }
            return if (tempStack.isEmpty()) "yes" else "no"
        }
    }
}