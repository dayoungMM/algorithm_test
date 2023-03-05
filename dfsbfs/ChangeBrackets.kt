package dfsbfs

class ChangeBrackets {
    companion object{
        fun isBalanced(p:String): Boolean{
            var total = 0
            p.forEach {
                if (it == '('){
                    total += 1
                } else {
                    if (total == 0){
                        return false
                    }
                    total -= 1
                }
            }
            return true
        }

        fun getBalancedIndex(p: String): Int {
            var total =0
            for (i in 0 until p.length) {
                if (p[i] == '(') {
                    total += 1
                } else{
                    total -= 1
                }
                if (total == 0){
                    return i
                }
            }
            return 0
        }

        fun solution(p: String): String{
            if (p == "") return ""
            var answer = ""
            var balancedIndex = getBalancedIndex(p)
            var u = p.slice(0..balancedIndex)
            var v = p.slice(balancedIndex+1 until p.length)
            //올바른 문자열이면 v 열과 붙여서 리턴
            if (isBalanced(u)){
                answer = u+ solution(v)
            } else{
                answer += '('
                answer += solution(v)
                answer += ')'
                var temp = u.slice(1 until u.length -1)
                var changedTemp = ""
                temp.forEach {
                    if (it == '(') {
                        changedTemp += ')'
                    } else {
                        changedTemp += '('
                    }
                }
                answer += changedTemp
            }
            return answer
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(solution("()))((()"))
        }
    }
}