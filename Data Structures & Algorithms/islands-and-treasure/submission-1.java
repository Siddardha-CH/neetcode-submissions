class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q= new ArrayDeque<>(); 
        int inf = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 0)
                    q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] k = q.poll();
            int r = k[0];
            int c = k[1];
            if (n > r + 1 && grid[r + 1][c] == inf) {
                grid[r + 1][c] = grid[r][c] + 1;
                q.add(new int[]{r + 1,c});
            }
            if (r - 1 >= 0 && grid[r - 1][c] == inf) {
                grid[r - 1][c] = grid[r][c] + 1;
                q.add(new int[]{r - 1,c});
            }
            if (m > c + 1 && grid[r][c + 1] == inf) {
                grid[r][c + 1] = grid[r][c] + 1;
                q.add(new int[]{r,c + 1});
            }
            if (c - 1 >= 0 && grid[r][c - 1] == inf) {
                grid[r][c - 1] = grid[r][c] + 1;
                q.add(new int[]{r,c - 1});
            }
        }              
    }
}
