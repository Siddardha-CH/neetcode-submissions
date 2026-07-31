class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++)
                freq[s.charAt(i) - 'a'] += 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < freq[i]; j++)
                    sb.append((char)('a' + i));
            String k = sb.toString();
            if (!map.containsKey(k))
                map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }
        for (List<String> k : map.values())
            ans.add(k);
        return ans;
    }
}
