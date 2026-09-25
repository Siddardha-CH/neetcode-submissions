class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (isVal(board, word, i, j, 0)) //here 0 gives the length of the word
                    return true;
        return false;
    }
    public boolean isVal(char[][] k, String w, int i, int j, int len) {
        if (len == w.length())
            return true;
        if (i < 0 || i >= k.length || j < 0 || j >= k[0].length || k[i][j] != w.charAt(len))
            return false;
        char c = k[i][j];
        k[i][j] = '-'; // marking as visted
        if (isVal(k, w, i + 1, j, len + 1) || isVal(k, w, i -1, j, len + 1) || isVal(k, w, i, j + 1, len + 1) || isVal(k, w, i, j - 1, len + 1))
            return true;
        k[i][j] = c;
        return false;
    }
}
