package implement


internal class Combination(private val n: Int, private val r: Int) {
    // 현재 조합
    private val now : IntArray
    // 모든 조합
    val result: ArrayList<ArrayList<Position>>

    init {
        now = IntArray(r)
        result = ArrayList()
    }

    fun combination(arr: ArrayList<Position>, depth: Int, index: Int, target: Int) {
        if (depth == r) {
            val temp = ArrayList<Position>()
            for (i in now.indices) {
                temp.add(arr[now[i]])
            }
            result.add(temp)
            return
        }
        if (target == n) return
        now[index] = target
        combination(arr, depth + 1, index + 1, target + 1)
        combination(arr, depth, index, target + 1)
    }
}

class Position(val x: Int, val y: Int)

class ChickenDelivery {

    companion object{
        var n = 0
        var m = 0
        var arr = Array(50) { IntArray(50) }
        var chicken = ArrayList<Position>()
        var house = ArrayList<Position>()
        fun getSum(candidates: ArrayList<Position>): Int {
            var result = 0
            // 모든 집에 대하여
            for (i in house.indices) {
                val hx = house[i].x
                val hy = house[i].y
                // 가장 가까운 치킨 집을 찾기
                var temp = 1e9.toInt()
                for (j in candidates.indices) {
                    val cx = candidates[j].x
                    val cy = candidates[j].y
                    temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy))
                }
                // 가장 가까운 치킨 집까지의 거리를 더하기
                result += temp
            }
            // 치킨 거리의 합 반환
            return result
        }


        @JvmStatic
        fun main(args: Array<String>) {
            val sc = readln().split(" ")
            n = sc[0].toInt()
            m = sc[1].toInt()
            for (r in 0  until n) {
                val row = readln().split(" ").map { it.toInt() }
                for (c in 0 until n) {
                    arr[r][c] = row[c]
                    if (arr[r][c] == 1) house.add(Position(r, c)) // 일반 집
                    else if (arr[r][c] == 2) chicken.add(Position(r, c)) // 치킨집
                }
            }

            // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
            val comb = Combination(chicken.size, m)
            comb.combination(chicken, 0, 0, 0)
            val chickenList = comb.result

            // 치킨 거리의 합의 최소를 찾아 출력
            var result = 1e9.toInt()
            for (i in chickenList.indices) {
                result = Math.min(result, getSum(chickenList[i]))
            }
            println(result)
        }
    }

}
