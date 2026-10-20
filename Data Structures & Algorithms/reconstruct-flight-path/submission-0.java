class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> i : tickets) {
            if (!map.containsKey(i.get(0)))
                map.put(i.get(0), new PriorityQueue<>());
            map.get(i.get(0)).add(i.get(1));
        }
        func (map, "JFK");
        Collections.reverse(ans);
        return ans;
    }
    void func (Map<String, PriorityQueue<String>> map, String curr) {
        PriorityQueue<String> pq = map.get(curr);
        while (pq != null && !pq.isEmpty()) 
            func (map, pq.poll());
        ans.add(curr);
    }
}
