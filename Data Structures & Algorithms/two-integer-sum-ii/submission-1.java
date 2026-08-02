class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (r > l) {
            int c = nums[l] + nums[r];
            if (c > target) 
                r -= 1;
            else if (c < target)
                l += 1;
            else
                return new int[] {l + 1,r + 1};
        }
        return new int[] {0};
    }
}
