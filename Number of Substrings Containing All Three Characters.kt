class Solution {
    fun numberOfSubstrings(s: String): Int {
        val pos = arrayOf(-1, -1, -1)
        var result = 0

        s.forEachIndexed { index, char ->
            pos[char -'a'] = index
            result += Math.min(pos[0], Math.min(pos[1], pos[2])) + 1
        }

        println(result)
        return result
    }
}
