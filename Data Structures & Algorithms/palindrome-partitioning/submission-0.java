class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        func (s, 0, new ArrayList<>());
        return ans;
    }
    public void func (String s, int i, ArrayList<String> k) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(k));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPal(s, i, j)) {
                k.add(s.substring(i, j + 1));
                func(s, j + 1, k);
                k.remove(k.size() - 1);
            }
        }   
    }
    public boolean isPal(String s, int l, int r) {
        while (r > l) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l += 1;
            r -= 1;
        }
        return true;
    }
}
