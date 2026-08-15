class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (x, y) -> Integer.compare(y[0], x[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] i : arr) {
            double time = (double)(target - i[0]) / i[1];
            if (stack.isEmpty()  || time > stack.peek())
                stack.push(time);
        }
        return stack.size();
    }
}
