// class Solution {
//     public List<String> findWords(char[][] board, String[] words) {
//         List<String> ans = new ArrayList<>();
//         int n = board.length;
//         int m = board[0].length;
//         boolean found = false;
//         for (String s : words)
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < m; j++) {
//                     if (board[i][j] == s.charAt(0))
//                         if (func(board, s, i, j, 0)) {
//                             ans.add(s);
//                             found = true;
//                             break;
//                         }
//                 }
//                 if (found) {
//                     found = false;
//                     break;
//                 }
//             }
//         return ans;
//     }
//     public boolean func(char[][] b, String s, int i, int j, int l) {
//         if (l == s.length())
//             return true;
//         if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != s.charAt(l))
//             return false;
//         b[i][j] = '.';
//         boolean t = func(b, s, i + 1, j, l + 1) || func(b, s, i - 1, j, l + 1) || func(b, s, i, j + 1, l + 1) || func(b, s, i, j - 1, l + 1);
//         b[i][j] = s.charAt(l);
//         return t;
//     }
// }
//                     GOT TLE




class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        Trie root = new Trie();
        for (String s : words)
            insert(root, s);
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++)
                if (root.child[board[i][j] - 'a'] != null)
                    func(board, root, i, j);
        return ans;
    }


    public void func(char[][] b, Trie root, int i, int j) {
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length)
            return;
        if (b[i][j] == '.')
            return;
        int idx = b[i][j] - 'a';
        if (root.child[idx] == null)
            return;
        root = root.child[idx];
        if (root.endofword) {
            root.endofword = false; // so that again it wont be added
            ans.add(root.word);
        }
        char t = b[i][j];
        b[i][j] = '.';
        func(b, root, i + 1, j);
        func(b, root, i - 1, j);
        func(b, root, i, j - 1);
        func(b, root, i, j + 1);
        b[i][j] = t;
    }


    public void insert(Trie root, String s) {
        Trie curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (curr.child[idx] == null)
                curr.child[idx] = new Trie();
            curr = curr.child[idx];
        }
        curr.endofword = true;
        curr.word = s;
    }
}
class Trie {
    Trie[] child = new Trie[26];
    boolean endofword;
    String word;

}
