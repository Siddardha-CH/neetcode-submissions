class Solution {
    public int[] productExceptSelf(int[] nums) {
        long tot = 1;
        int n = nums.length;
        int c = 0;
        for (int i : nums)
            if (i != 0)
                tot *= i;
            else
                c += 1;
        int[] ans = new int[n];
        if (c > 1) {
            Arrays.fill(ans, 0);
            return ans;
        }
        else if (c == 1) {
            for (int i = 0; i < n; i++)
                if (nums[i] != 0)
                    ans[i] = 0;
                else
                    ans[i] = (int)tot;
            return ans;
        }
        else {
            for (int i = 0; i < n; i++)
                ans[i] = (int)(tot / nums[i]);
        }
        return ans;
    }
}  
