class Solution {
    String[] k = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans; 
        func(digits, 0, new StringBuilder());
        return ans;
    }
    public void func(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int idx = digits.charAt(i) - '2';
        for (int j = 0; j < k[idx].length(); j++) {
            sb.append(k[idx].charAt(j));
            func (digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
