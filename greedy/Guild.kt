package greedy

class Guild {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n = readln().toInt()
            var people = readln().split(" ").map { it.toInt() }.sorted()
            println("mysolution: ${mysolution(n, people)}")
            println("answoer: ${answer(n, people)}")
        }

        private fun mysolution(count: Int, p: List<Int>): Int {
            var result = 0
            var n = count
            var people = p
            while (n > 0) {
                val scare = people[0]
                // 공포도만큼 인원이 남아있고, 길드에 모은 인원보다 더 높은 공포도 가진 인원이 없을 때
                if (scare <= n && scare <= people[scare-1]) {
                    people = people.slice(scare until n)
                    result += 1
                    n -= scare
                } else {
                    //길드 생성 실패하여 마을에 잔류
                    people = people.drop(0)
                    n -= 1
                }
            }
            return result
        }

        private fun answer(count: Int, p: List<Int>): Int {
            var result = 0

            var membersCnt = 0
            p.forEach{scare ->
                // 우선 제일 공포도 낮은 인원 넣고
                membersCnt += 1
                // 그룹의 모험가 수가 현재 공포도 이상이면 그룹 결성
                if (membersCnt >= scare) {
                    result += 1
                    membersCnt = 0
                }
            }
            return result


        }
    }
}