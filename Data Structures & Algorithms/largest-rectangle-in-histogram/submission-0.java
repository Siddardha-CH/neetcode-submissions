class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int st = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] t = stack.pop();
                int idx = t[0];
                int hgt = t[1];
                ans = Math.max(ans, hgt * (i - idx));
                st = idx; // updating as per left movement
            }
            stack.push(new int[] {st, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] t = stack.pop();
            int idx = t[0];
            int hgt = t[1];
            ans = Math.max(ans, hgt * (n - idx));
        }
        return ans;
    }
}
