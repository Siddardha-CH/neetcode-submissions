class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    ans = Math.max(ans, func(grid, i, j));
        return ans;
    }
    public int func(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        int res = 1;
        grid[i][j] = 0;
        res += (func(grid, i + 1, j) + func(grid, i - 1, j) + func(grid, i, j + 1) + func(grid, i, j - 1));
        return res;
    }
}
