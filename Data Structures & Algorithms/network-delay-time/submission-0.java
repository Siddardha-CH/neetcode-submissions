class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for (int[] i : times) {
            int u = i[0];
            int v = i[1];
            int w = i[2];
            if (!map.containsKey(u))
                map.put(u, new ArrayList<>());
            map.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, k}); // as root node cost = 0;
        Set<Integer> seen = new HashSet<>();
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int w = temp[0];
            int d = temp[1];
            if (seen.contains(d))
                continue;
            seen.add(d);
            ans = Math.max(ans, w);
            if (map.get(d) == null)
                continue;
            for (int[] i : map.get(d)) {
                int d2 = i[0];
                int w2 = i[1];
                if (!seen.contains(d2))
                    pq.offer(new int[]{w + w2, d2}); // summing up the costs here
            }
        }
        if (seen.size() == n)
            return ans;
        return -1;
    }
}
