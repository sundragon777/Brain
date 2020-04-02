class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int { 
        var start = 0
        var diff = 0
        var sum = 0

        gas.mapIndexed { index, gas ->
            diff += gas - cost[index]
            if(diff < 0) {
                sum += diff
                diff = 0
                start = index + 1
            }
        }
        sum += diff
        return when(sum < 0) {
            true -> -1
            else -> start
        }
    }
}
