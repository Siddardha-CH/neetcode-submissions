class WordDictionary {
    Trie node;
    public WordDictionary() {
        node = new Trie();
    }

    public void addWord(String word) {
        Trie curr = node;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new Trie();
            curr = curr.children[idx];
        }
        curr.endofword = true;
    }

    public boolean search(String word) {
        return dfs(word, node, 0);
    }
    public boolean dfs(String word, Trie curr, int idx) {
        if (idx == word.length())
            return curr.endofword;
        char c = word.charAt(idx);
        if (c != '.') {
            int i = c - 'a';
            if (curr.children[i] == null)
                return false;
            return dfs(word, curr.children[i], idx + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null)
                if (dfs(word, curr.children[i], idx + 1))
                    return true;
        }
        return false;
    }
}
class Trie {
    Trie[] children = new Trie[26];
    boolean endofword = false;
}
