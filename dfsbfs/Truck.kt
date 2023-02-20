package dfsbfs



class Truck {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val (n, w, L) = readln().split(" ").let { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
            val ready = readln().split(" ").map { it.toInt() }.toMutableList()
            var sum = 0
            var bridge = mutableListOf<Int>()
            var timespent = mutableListOf<Int>()
            var totalTime = 0
            while (true){
                if (timespent.size == 0 && ready.size == 0){
                    break
                }

                if(timespent.size == 0){
                    timespent.add(w)
                    sum += ready[0]
                    bridge.add(ready[0])
                    ready.removeAt(0)
                }else {
                    //이동도 하고
                    if (timespent[0] -1 <= 0){
                        sum -= bridge[0]
                        bridge.removeAt(0)
                        timespent.removeAt(0)
                    }
                    timespent = timespent.map { it -1 }.toMutableList()
                    // 다리에 올라가기도 하고
                    if (ready.size >0 && sum + ready[0] <= L) {
                        timespent.add(w)
                        sum += ready[0]
                        bridge.add(ready[0])
                        ready.removeAt(0)
                    }
                }
                totalTime +=1
            }
            println(totalTime)
        }
    }
}