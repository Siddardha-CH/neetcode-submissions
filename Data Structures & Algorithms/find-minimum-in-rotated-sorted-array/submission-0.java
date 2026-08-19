class Solution {
    public int findMin(int[] nums) {
        int ans = -1;
        int l = 0;
        int r = nums.length - 1;
        while (r > l) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r])
                l = m + 1;
            else 
                r = m;
        }
        return nums[l];
    }
}
