class Solution {
    private var result = arrayListOf<String>()
    
    fun generateParenthesis(n: Int): List<String> {
        backTrack(0, 0, n, "")
        
        return result
    }
    
    private fun backTrack(left: Int, right: Int, n: Int, given: String) {
        if(right == n) {
            result.add(given)
            return
        }
        if(left < n) {
            backTrack(left.plus(1), right, n, "$given(")
        }
        if(right < left) {
            backTrack(left, right.plus(1), n, "$given)")
        }
    }
}
