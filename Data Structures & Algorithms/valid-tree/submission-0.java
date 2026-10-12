class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) // maybe no connectins or loops
            return false;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n ; i++)
            list.add(new ArrayList<>());
        for (int[] i : edges) {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        boolean[] seen = new boolean[n];
        dfs(0, list, seen);
        for (boolean b: seen)
            if (!b)
                return false;
        return true;
    }
    public void dfs(int i, List<List<Integer>> list, boolean[] seen) {
        seen[i] = true;
        for (int j : list.get(i))
            if (!seen[j])
                dfs(j, list, seen);
    }
}
