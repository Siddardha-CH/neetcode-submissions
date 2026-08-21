class TimeMap {
    public Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        }
        else {
            TreeMap<Integer, String> t = new TreeMap<>();
            t.put(timestamp, value);
            map.put(key,t);
        }
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp); // helps returnning the the same timestamp or preivious timestamp
            if (entry != null)
                return entry.getValue();
        }
        return "";
    }
}
