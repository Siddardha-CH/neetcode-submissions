class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O')
                func(grid, i, 0);
            if (grid[i][m - 1] == 'O')
                func(grid, i, m - 1);
        }    
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 'O')
                func(grid, 0, i);
            if (grid[n - 1][i] == 'O')
                func(grid, n - 1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
                else if (grid[i][j] == 'V')
                    grid[i][j] = 'O';
        
    }
    public void func(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i>= n || j>= m || grid[i][j] != 'O')
            return;
        grid[i][j] = 'V'; // its  va laid path or region
        func(grid, i + 1, j);
        func(grid, i - 1, j);
        func(grid, i, j + 1);
        func(grid, i, j - 1);
    }
}
