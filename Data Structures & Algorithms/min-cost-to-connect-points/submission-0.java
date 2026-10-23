class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int ax = points[i][0];
            int ay = points[i][1];
            for (int j = i + 1; j < n; j ++) {
                int bx = points[j][0];
                int by = points[j][1];
                int dis = Math.abs(ax - bx) + Math.abs(by - ay);
                map.get(i).add(new int[]{dis, j});
                map.get(j).add(new int[]{dis, i});
            }
        }
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0,0});
        Set<Integer> set = new HashSet<>();
        while (set.size() < n) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int des = curr[1];
            if (set.contains(des))
                continue;
            ans += cost;
            set.add(des);
            for (int[] i : map.get(des))
                if (!set.contains(i[1]))
                    pq.offer(new int[]{i[0], i[1]});
        }
        return ans;
    }
}
