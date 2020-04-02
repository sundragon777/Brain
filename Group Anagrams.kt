class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var map = hashMapOf<String, ArrayList<String>>()
        strs.map {
            val key = it.toCharArray().sortedDescending().toString()
            if(!map.containsKey(key)) map.put(key, arrayListOf())
            map[key]?.add(it)
        }
        println("map values : ${map.values}")
        return ArrayList<List<String>>(map.values)
    }
}
