class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks)
            freq[c - 'A'] += 1;
        Arrays.sort(freq);
        int max = freq[25];
        int totidle = (max - 1) * n;
        for (int i = 0; i < 25; i++)
            totidle -= Math.min(freq[i], max - 1);
        int ans = Math.max(0, totidle) + tasks.length;
        return ans;
    }
}
