class KthLargest {
    PriorityQueue<Integer> pq;
    int kk;
    public KthLargest(int k, int[] nums) {
        kk = k;
        pq = new PriorityQueue<>();
        for (int i : nums)
            pq.offer(i);
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() != kk)
            pq.poll();
        return pq.peek();
    }
}
