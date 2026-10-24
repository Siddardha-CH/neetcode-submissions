class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<String> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        set.add("0-0");
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int i = curr[1];
            int j = curr[2];
            String idx = i + "-" + j;
            if (i == n - 1 && j == n - 1)
                return cost;
            //move rigt
            int rj = j + 1;
            if (rj < n && !set.contains(i +"-" + rj)) {
                set.add(i + "-" + rj);
                pq.offer(new int[]{Math.max(cost, grid[i][rj]), i, rj});
            }   
            //move down
            int di = i + 1;
            if (di < n && !set.contains(di + "-" + j)) {
                set.add(di + "-" + j);
                pq.offer(new int[]{Math.max(cost, grid[di][j]), di, j});
            }
            // move left
            int lj = j - 1;
            if (lj > -1 && !set.contains(i +"-" + lj)) {
                set.add(i + "-" + lj);
                pq.offer(new int[]{Math.max(cost, grid[i][lj]), i, lj});
            } 
            // move up
            int ui = i - 1;
            if (ui > -1 && !set.contains(ui +"-" + j)) {
                set.add(ui + "-" + j);
                pq.offer(new int[]{Math.max(cost, grid[ui][j]), ui, j});
            } 
        }
        return -1;
    }
}
