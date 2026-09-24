class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        func(nums, new ArrayList<>(), new HashSet<>());
        return ans;
    }
    public void func(int[] nums, ArrayList<Integer> k, HashSet<Integer> kk) {
        if (k.size() == nums.length) {
            ans.add(new ArrayList<>(k));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (kk.contains(nums[i]))
                continue;
            k.add(nums[i]);
            kk.add(nums[i]);
            func(nums, k, kk);
            k.remove(k.size() - 1);
            kk.remove(nums[i]);
        }
    }
}
