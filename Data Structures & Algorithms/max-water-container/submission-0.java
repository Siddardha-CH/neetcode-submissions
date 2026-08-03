class Solution {
    public int maxArea(int[] nums) {
        int ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while (r > l) {
            int area = Math.min(nums[l], nums[r]) * (r - l);
            ans = Math.max(ans, area);
            if (nums[r] > nums[l])
                l += 1;
            else
                r -= 1;
        }
        return ans;
    }
}
