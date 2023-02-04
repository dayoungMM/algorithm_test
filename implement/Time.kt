package implement

class Time {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //탐색해야할 전체 데이터가 100만개 이하일 때 완전 탐색을 사용하면 적절하다
            var N = 5
            var answer = 0
            for (h in 0..N) {
                for (m in 0..59) {
                    for (s in 0..59) {
                        if ((h.toString() + m.toString() + s.toString()).contains("3")) {
                            answer += 1
                        }
                    }
                }
            }
            println(answer)
        }

    }
}