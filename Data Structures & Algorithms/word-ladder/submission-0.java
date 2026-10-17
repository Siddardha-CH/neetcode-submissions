class Solution {
    public int ladderLength(String start, String end, List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        if (!words.contains(end)) // no possibility
            return 0;
        words.add(start);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!map.containsKey(pattern))
                    map.put(pattern, new ArrayList<>());
                map.get(pattern).add(word);
            }
        }
        int ans = 1;
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        seen.add(start);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String word = q.poll();
                if (word.equals(end))
                    return ans;
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    if (map.containsKey(pattern))
                        for (String w : map.get(pattern)) {
                            if (!seen.contains(w)) {
                                q.offer(w);
                                seen.add(w);
                            }
                        }
                }
            }
            ans += 1;
        }
        return 0;
    }
}
