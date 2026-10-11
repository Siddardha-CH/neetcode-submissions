class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<>());
        for (int[] i : prerequisites)
            map.get(i[0]).add(i[1]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(i))
                return false;
        return true;
    } 
    public boolean dfs(int curr) {
        if (set.contains(curr))
            return false;
        if (map.get(curr).isEmpty()) // no elemnts to compute
            return true;
        set.add(curr);
        for (int i : map.get(curr))
            if (!dfs(i))
                return false;
        set.remove(curr);
        map.put(curr, new ArrayList<>()); // rmeoving curr or its entry done
        return true;
    }
}
