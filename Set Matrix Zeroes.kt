class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = arrayListOf<Int>()
        val cols = arrayListOf<Int>()

        matrix.forEachIndexed { rowIndex, _ ->
            matrix[0].forEachIndexed { colIndex, _ ->
                when(matrix[rowIndex][colIndex] == 0) {
                    true -> {
                        rows.add(rowIndex)
                        cols.add(colIndex)
                    }
                }
            }
        }

        matrix.forEachIndexed { rowIndex, _ ->
            matrix[0].forEachIndexed { colIndex, _ ->
                when(rows.contains(rowIndex) || cols.contains(colIndex)) {
                    true -> {
                        matrix[rowIndex][colIndex] = 0
                    }
                }
            }
        }
    }
}
