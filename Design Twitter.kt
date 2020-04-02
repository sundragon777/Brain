class Twitter() {

    private var followMap = hashMapOf<Int, ArrayList<Int>>()
    private var postMap = hashMapOf<Int, ArrayList<PostTweet>>()
    private var timestamp = 0
    
    fun postTweet(userId: Int, tweetId: Int) {
        if(!postMap.containsKey(userId)) postMap[userId] = arrayListOf()
        postMap[userId]?.run {
            add(PostTweet(userId, tweetId, timestamp))
            timestamp++
        }
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feeds = arrayListOf<PostTweet>()
        postMap[userId]?.run {
            feeds.addAll(this)
        }
        followMap[userId]
            ?.map { id ->
                postMap[id]?.filter { it.userId == id }?.run {
                    feeds.addAll(this)
                }
            }
        feeds.sortByDescending { it.timestamp }
        return feeds.map { it.tweetId }.distinctBy { it }.take(10)
    }


    fun follow(followerId: Int, followeeId: Int) {
        if(!followMap.containsKey(followerId)) followMap[followerId] = arrayListOf()
        followMap[followerId]?.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
             if(followMap.containsKey(followerId).not()) return
        followMap[followerId]?.remove(followeeId)
    }
    
    
    inner class PostTweet(
        val userId: Int,
        val tweetId: Int,
        val timestamp: Int
    )
}
