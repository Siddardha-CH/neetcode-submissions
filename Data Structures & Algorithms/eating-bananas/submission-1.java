class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;
        for (int i : piles) 
            r = Math.max(r, i);
        int ans = r;
        while (r >= l) {
            int m = (r - l) / 2 + l;
            int k = 0;
            for (int i : piles)
                k += Math.ceilDiv(i, m);
            if (k <= h) {
                ans = m;
                r = m - 1;
            }
            else
                l = m + 1;
        }
        return ans;
    }
}
