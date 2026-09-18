class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones)
            pq.offer(i);
        while (pq.size() != 1) 
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}
