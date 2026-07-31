class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (map.containsKey(d) && map.get(d) != i) // if there are smae multipe differences the ith refernece replaced by new reference of nums[i]
                return new int[] {i, map.get(d)};
        }
        return new int[] {0};
    }
}
