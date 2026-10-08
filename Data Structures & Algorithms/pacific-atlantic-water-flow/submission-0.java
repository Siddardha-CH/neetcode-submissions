class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            func(grid, pac, i, 0 , -1);
            func(grid, atl, i, m - 1, -1);
        }
        for (int i = 0; i < m; i++) {
            func(grid, pac, 0, i, -1);
            func(grid, atl, n - 1, i, -1);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pac[i][j] && atl[i][j])
                    ans.add(Arrays.asList(i,j));
        return ans;
    }
    public void func(int[][] grid, boolean[][] arr, int i, int j, int prevh) {
        int n = arr.length;
        int m = arr[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || arr[i][j] || prevh > grid[i][j])
            return;
        arr[i][j] = true;
        func(grid, arr, i + 1, j, grid[i][j]);
        func(grid, arr, i - 1, j, grid[i][j]);
        func(grid, arr, i, j + 1, grid[i][j]);
        func(grid, arr, i, j - 1, grid[i][j]);
    }
}
