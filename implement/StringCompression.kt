package implement

import kotlin.math.min

class StringCompression {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            require(answer("aabbaccc") == 7)
            require(answer("ababcdcdababcdcd") == 9)
            require(answer("abcabcdede") == 8)
            require(answer("abcabcabcabcdededededede") == 14)
            require(answer("xababcdcdababcdcd") == 17)
        }

        // 답보고 실패 코드 수정
        private fun answer(s: String): Int {
            var result = mutableListOf<Int>()
            var length = s.length
            result.add(length)
            // 압축한 문자열의 길이 리스트
            var compressed = String()
            //압축 횟수
            var duplicateCnt = 0

            for (step in 1..length / 2) {
                var count = 1
                var previous = s.substring(0 until step)
                //step 크기만큼 증가시키며 이전 문자열과 비교
                for (j in step until length - step step step) {
                    // 이전 상태와 동일하면 압축횟수 증가
                    if (previous == s.substring(j until j + step)) {
                        duplicateCnt += 1
                    } else {
                        val addString = if (duplicateCnt > 0) {
                            count.toString() + previous
                        } else {
                            previous
                        }
                        compressed += addString
                        //현재가 이전 문자가 되고
                        previous = s.substring(j until j + step)
                        // initialize
                        duplicateCnt = 0

                    }
                }
                // 남아있는 문자 처리
                val addString = if (duplicateCnt > 0) {
                    count.toString() + previous
                } else {
                    previous
                }
                compressed += addString

                result.add(compressed.length)
            }
            return result.minOrNull() ?: length
        }


        // 실패
//        private fun solution(s: String): Int {
//            var cursor = 0
//            var length = s.length
//
//            // 압축한 문자열의 길이 리스트
//            var compressed = mutableListOf<Int>()
//            var duplicateCnt = 0
//            var previous = String()
//            for (cnt in 1..length / 2) {
//                // 문자 길이
//                var tempLength = length
//                while (cursor < length) {
//                    val current = s.substring(cursor, cursor + cnt)
//                    if (previous == current) {
//                        duplicateCnt += 1
//                        // 중복된 문자만큼 길이가 줄어듦
//                        tempLength -= cnt
//                    } else if (duplicateCnt > 0) {
//                        // 중복되지 않으면, previous에 넣고, 여태껏 중복된 문자 압축
//                        // 중복갯수만큼 숫자가 추가되므로 길이가 1 늘어남
//                        tempLength += 1
//                        duplicateCnt = 0
//                    } else {
//                        duplicateCnt = 0
//                    }
//                    previous = current
//                    // 커서 이동
//                    cursor += cnt
//
//                }
//                compressed.add(tempLength)
//            }
//            println(compressed)
//            return compressed.minOrNull() ?: length
//        }
    }
}