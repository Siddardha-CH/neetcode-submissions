class Solution {
    public int trap(int[] nums) {
        //APPROACH - 1
        // SPACE_COMPLEXITTY : O(N)
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = 0;
        rmax[n - 1] = 0;
        for (int i = 1; i < n; i++)
            lmax[i] = Math.max(lmax[i - 1], nums[i - 1]);
        for (int i= n - 2; i >= 0; i--)
            rmax[i] = Math.max(rmax[i + 1], nums[i + 1]);
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int k = Math.min(lmax[i], rmax[i]) - nums[i];
            if (k > 0)
                ans += k;
        }
        return ans;
    }
}
