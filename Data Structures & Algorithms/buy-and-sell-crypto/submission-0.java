class Solution {
    public int maxProfit(int[] prices) {
        //APPROACH-1
        //2-POINTER
        int l = 0;
        int r = 1;
        int ans = 0;
        while (r < prices.length) {
            if (prices[r] > prices[l]) 
                ans = Math.max(ans, prices[r] - prices[l]);
            else
                l = r;
            r += 1;
        }
        return ans;
    }
}
