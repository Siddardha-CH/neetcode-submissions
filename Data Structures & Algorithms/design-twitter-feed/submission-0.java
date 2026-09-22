class Twitter {
    Map<Integer, HashSet<Integer>> follow;
    Map<Integer, List<int[]>> tweets;
    int time;
    public Twitter() {
        follow = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            List<int[]> l = new ArrayList<>();
            tweets.put(userId, l);
        }
        int[] k = new int[] {time, tweetId};
        time += 1;
        tweets.get(userId).add(k);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> k = follow.getOrDefault(userId, new HashSet<>());
        k.add(userId);
        for (int i : k) 
            if (tweets.containsKey(i))
                for (int[] j : tweets.get(i))
                    pq.offer(j);
        while (!pq.isEmpty() && ans.size() != 10) {
            int[] temp = pq.poll();
            ans.add(temp[1]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            HashSet<Integer> l = new HashSet<>();
            follow.put(followerId, l);
        }
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId) && follow.get(followerId).contains(followeeId))
            follow.get(followerId).remove(followeeId);
    }
}
