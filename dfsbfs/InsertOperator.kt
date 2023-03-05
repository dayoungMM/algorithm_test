package dfsbfs

import java.util.Queue

class InsertOperator {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val n = readln().toInt()
            val elements = readln().split(" ").map { it.toInt() }
            //덧셈, 뺄셈, 곱셈, 나눗셈
            val operatorNum = readln().split(" ").map { it.toInt() }.toMutableList()
            val result = mutableListOf<Int>()

            fun calculate(operatorQueue: ArrayDeque<Int>, prevSum:Int, currentIndex:Int ):Int {
                if (operatorQueue.isEmpty()){
                    return prevSum
                }
                val operatorIndex = operatorQueue.removeFirst()
                val sum = when(operatorIndex){
                    0 -> prevSum + elements[currentIndex]
                    1 -> prevSum - elements[currentIndex]
                    2 -> prevSum * elements[currentIndex]
                    else -> prevSum / elements[currentIndex]
                }
                return calculate(operatorQueue, sum, currentIndex+1)
            }

            fun dfs(operatornum: MutableList<Int>, operatorQueue: ArrayDeque<Int>, index:Int) {
                //index가 n-1이 되면 리턴
                if (index == n-2){
                    for(i in 0 until 4){
                        if (operatornum[i] > 0){
                            operatorQueue.addLast(i)
                            result.add(calculate(operatorQueue, elements[0], 1))
                        }
                    }
                    return
                }
                //사칙연산 다 해보기

                for(i in 0 until 4){
                    if (operatornum[i] > 0){
                        operatornum[i] -=1
                        val tempQueue = ArrayDeque<Int>()
                        operatorQueue.forEach {
                            tempQueue.add(it)
                        }
                        tempQueue.addLast(i)
                        dfs(operatornum, tempQueue, index +1)
                        operatornum[i] +=1
                    }
                }
            }

            dfs(operatorNum, ArrayDeque<Int>(), 0)
            // 여기서 result 리스트를 max, min 하지 말고 var max:Int와 var min: Int 에 직접 업데이트 하는 방법이 더 좋을듯 하다
            println(result.max())
            println(result.min())
        }
    }
}