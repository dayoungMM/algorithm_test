package implement

class LockerKey {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1)),
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)))

            require(result == true)
        }

        //어려워서 답지보고 구현
        // rotate 하는 함수 만들어놓고, 자물쇠 array를 수직/수평 방향으로 3배 크기로 확대해서 0으로 padding 처리한 후, rotate + move 해서 다 커버하는지 확인하는 방법

        // array를 시계방향으로 90도 회전
        private fun rotate90(arr: Array<IntArray>): Array<IntArray> {
            //행길이
            val n = arr.size
            //열길이
            val m = arr[0].size
            var newArray = Array(n) { IntArray(m) }
            for (i in 0 until n) {
                for (j in 0 until m) {
                    newArray[j][n - i - 1] = arr[i][j]
                }
            }
            return newArray
        }

        // 9배 된 arr중에 가장 가운데의 original 자물쇠 arr를 체크
        private fun check(arr: Array<IntArray>): Boolean {
            val lockLength = arr.size / 3
            for (i in lockLength until lockLength*2) {
                for (j in lockLength until lockLength*2) {
                    if (arr[i][j] < 1) {
                        return false

                    }
                }
            }
            return true
        }

//        private fun printArrForDebug(arr: Array<IntArray>) {
//            for (i in 0 until arr.size) {
//                for (j in 0 until arr[0].size) {
//                    print(arr[i][j])
//                }
//                println()
//            }
//            println(">>>>>>>>>>>>>")
//        }

        private fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
            // 수평, 수직으로 arr 확대 후 padding
            val lockN = lock.size
            val keyN = key.size
            var newArr = Array(lockN * 3) { IntArray(lockN * 3) }
            // 한가운데에 자물쇠 위치
            // 여기를 lockN 써야해!!!
            for (i in 0 until lockN) {
                for (j in 0 until lockN) {
                    newArr[lockN + i][lockN + j] = lock[i][j]
                }
            }
            // rotate 하기
            var rotatedKey = key
            for (cnt in 0 until 4) {
                rotatedKey = rotate90(rotatedKey)

                // 각 rotate마다 이동해서 열쇠 끼워넣기
                for (i in  0 until lockN*2) {
                    for (j in 0 until lockN*2) {
                        // 끼워넣기
                        for (row in 0 until keyN) {
                            for (col in 0 until keyN) {
                                newArr[i+row][j+col] += rotatedKey[row][col]
                            }
                        }
                        //맞는지 확인
                        if (check(newArr)) {
                            return true
                        } else {
                            // 열쇠 빼기
                            for (row in 0 until keyN) {
                                for (col in 0 until keyN) {
                                    newArr[i+row][j+col]    -= rotatedKey[row][col]
                                }
                            }
                        }
                    }
                }
            }

            return false
        }
    }

}
