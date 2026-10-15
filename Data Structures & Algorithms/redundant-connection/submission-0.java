class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++)
            list.add(new ArrayList<>());
        for (int[] i : edges) {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        int[] ans = new int[0];
        for (int[] i : edges) {
            list.get(i[0]).remove(Integer.valueOf(i[1]));
            list.get(i[1]).remove(Integer.valueOf(i[0]));
            boolean[] seen = new boolean[edges.length + 1];
            dfs(i[0], list, seen);
            boolean b = true;
            for (int j = 1; j < edges.length + 1; j++)
                if (!seen[j]) {
                    b = false;
                    break;
                }
            if (b)
                ans = i;
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        return ans;
    }
    public void dfs(int node, List<List<Integer>> list, boolean[] seen) {
        seen[node] = true;
        for (int i : list.get(node))
            if (!seen[i])
                dfs(i, list, seen);
            
    }
}
