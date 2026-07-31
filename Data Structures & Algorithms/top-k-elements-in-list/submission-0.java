class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            pq.offer(new int[]{element.getValue(), element.getKey()});
        } 
        while (pq.size() != k)
            pq.poll();
        for (int i = 0; i < k; i++)
            ans[i] = pq.poll()[1];
        return ans;
    }
}
