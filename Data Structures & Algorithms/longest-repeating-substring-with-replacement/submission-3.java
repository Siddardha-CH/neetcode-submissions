class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 1;
        int l = 0;
        int r = 0;
        int[] freq = new int[26];
        while (r != s.length() && l != s.length()) {
            freq[s.charAt(r) - 'A'] += 1;
            int max = 0;
            for (int i : freq)
                max = Math.max(i, max);
            while (r - l + 1 - max > k) {
                freq[s.charAt(l) - 'A'] -= 1;
                l += 1;
                max = 0;
                for (int i : freq)
                    max = Math.max(i, max);
            }
            ans = Math.max(ans, r - l + 1);
            r += 1;
        }
        return ans;
    }
}
