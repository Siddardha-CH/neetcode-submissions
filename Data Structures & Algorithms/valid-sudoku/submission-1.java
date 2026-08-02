class Solution {
    public boolean isValidSudoku(char[][] board) {
        // col by col
        for (char[] c : board) {
            Set<Character> set = new HashSet<>();
            for (char ch : c)
                if (ch != '.' && set.contains(ch))
                    return false;
                else
                    set.add(ch);
        }
        // row by row
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) 
                if (board[j][i] != '.' && set.contains(board[j][i]))
                    return false;
                else
                    set.add(board[j][i]);
        }
        // 3 x 3 matrices
        for (int k = 0; k < 9; k++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    int r = (k / 3) * 3 + i;
                    int c = (k % 3) * 3 + j;
                    if (board[r][c] != '.' && set.contains(board[r][c]))
                        return false;
                    else
                        set.add(board[r][c]);
                }
        }
        return true;
    }
}
