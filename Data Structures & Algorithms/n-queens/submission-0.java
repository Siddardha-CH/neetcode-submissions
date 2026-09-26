class Solution {
    List<List<String>> ans = new ArrayList<>();
    Set<Integer> column = new HashSet<>();
    Set<Integer> negdaig = new HashSet<>();
    Set<Integer> posdaig = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] b = new char[n][n];
        for (char[] i : b)
            Arrays.fill(i, '.');
        func (0, b, n);
        return ans;
    }
    public void func(int row, char[][] b, int n) {
        if (row == n) {
            List<String> k = new ArrayList<>();
            for (char[] i : b)
                k.add(new String(i));
            ans.add(k);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (column.contains(col) || posdaig.contains(col + row) || negdaig.contains(row -  col))
                continue;
            column.add(col);
            posdaig.add(row + col);
            negdaig.add(row - col);
            b[row][col] = 'Q';
            func (row + 1, b ,n);
            b[row][col] = '.';
            column.remove(col);
            posdaig.remove(col + row);
            negdaig.remove(row - col);
        }
    }
}
