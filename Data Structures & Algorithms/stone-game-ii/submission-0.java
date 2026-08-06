class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n][n + 1]; //2 players n length the m val can go upto n / 2 so n times of it is the x value
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);
        int ans = func(1, 0, 1, piles);
        return ans;
    }
    int func(int player, int i, int M, int[] piles) {
        if (i == piles.length)
            return 0;
        if (dp[player][i][M] != -1)
            return dp[player][i][M];
        int res;
        int sum = 0;
        if (player == 1)
            res = 0;
        else
            res = Integer.MAX_VALUE; // its bob turn hope for worst
        for (int x = 1; x <= 2 * M; x++) {
            if (i + x > piles.length)
                break;
            sum += piles[i + x - 1];
            if (player == 1)
                res = Math.max(res, sum + func(0, i + x, Math.max(x, M), piles));
            else
                res = Math.min(res, func(1, i + x, Math.max(x, M), piles));
        }
        dp[player][i][M] = res;
        return res;
    }
}
        