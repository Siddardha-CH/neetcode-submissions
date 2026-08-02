class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int cnt = 1;
                while (set.contains(i + cnt))
                    cnt += 1;
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
