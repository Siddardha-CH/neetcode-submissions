class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> k = new HashSet<>();
        for (int i : nums)
            if (k.contains(i))
                return true;
            else
                k.add(i);
        return false;
    }
}