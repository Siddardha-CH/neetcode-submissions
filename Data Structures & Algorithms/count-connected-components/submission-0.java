class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for (int i = 0;i < n; i++)
            list.add(new ArrayList<>());
        for (int[] i : edges) {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (seen[i] == false) {
                ans += 1;
                dfs(i, seen, list);
            }
        return ans;
    }
    public void dfs(int i, boolean[] seen, List<List<Integer>> list) {
        seen[i] = true;
        for (int nei : list.get(i))
            if (seen[nei] == false)
                dfs(nei, seen, list);
    }
}
