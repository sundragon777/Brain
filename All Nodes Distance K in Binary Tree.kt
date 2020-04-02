class Solution {
    
    var nodes = hashMapOf<TreeNode, TreeNode?>()
    var visitNodes = hashSetOf<TreeNode>()
    var result = arrayListOf<Int>()
    
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        
        setNode(root, null)
        search(target, 0, K)
        
        return result
    }
    
    fun setNode(node: TreeNode?, parentNode: TreeNode?) {
        node?.let {
            nodes.put(it, parentNode)
            setNode(it.left, it)
            setNode(it.right, it)
        }   
    }
    
    fun search(targetNode: TreeNode?, visit: Int, K: Int) {
        targetNode?.let {
            when (visitNodes.contains(it)) {
                true -> return 
                else -> visitNodes.add(it)
            } 
            
            if(visit == K) result.add(it.`val`)
            
            search(it.left, visit.plus(1), K)
            search(it.right, visit.plus(1), K)
            search(nodes.get(it), visit.plus(1), K)
        }
    }
}
