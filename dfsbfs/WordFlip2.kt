package dfsbfs

import java.util.*
import kotlin.text.StringBuilder

class WordFlip2 {
    companion object {
        val wordStack = Stack<Char>()
        var result = StringBuilder()
        var isWord = true
        @JvmStatic
        fun main(args: Array<String>) {
            val input = readln()
//            val tagList = mutableListOf<String>()

            input.forEach {
                //isWord가 false 인경우 append
                if (it.toString() == "<") {
                    reverseWord()
                    isWord = false
                    result.append(it)
                }else if (it.toString() == ">") {
                    isWord = true
                    result.append(it)
                }else if (it.toString() == " ") {
                    reverseWord()
                    result.append(it)
                } else if (isWord) {
                    //isWord가 true인경우 stack에 넣었다가 빼기
                    wordStack.add(it)
                } else {
                    result.append(it)
                }
            }

            reverseWord()

            println(result)
        }

        fun reverseWord(){
            while(wordStack.isNotEmpty()){
                result.append(wordStack.pop())
            }
        }
    }
}