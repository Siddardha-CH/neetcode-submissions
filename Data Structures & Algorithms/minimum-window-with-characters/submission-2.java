class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();//t
        Map<Character, Integer> map2 = new HashMap<>();//window
        int c = 0; // for how many required
        int l = -1; // ans string
        int r = -1; // ans string
        int j = 0;  // left pointer
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++)
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
                if (map2.get(s.charAt(i)).equals(map1.get(s.charAt(i))))
                    c += 1;;
            }
            while (c == map1.size()) {
                if (i - j + 1 < len) {
                    len = i - j + 1;
                    l = j;
                    r = i;
                }
                if (map1.containsKey(s.charAt(j))) {
                    map2.put(s.charAt(j), map2.get(s.charAt(j)) - 1);
                    if (map1.get(s.charAt(j)) > map2.get(s.charAt(j)))
                        c -= 1;
                }
                j += 1;
            }
        }
        if (len == Integer.MAX_VALUE)
            return "";
        return s.substring(l, r + 1);
    }
}
