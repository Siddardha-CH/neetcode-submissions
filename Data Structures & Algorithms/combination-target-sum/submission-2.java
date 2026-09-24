class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        func(nums, target, 0, new ArrayList<>());
        return ans;
    }
    public void func (int[] nums, int t, int i, ArrayList<Integer> k) {
        if (t == 0) {
            ans.add(new ArrayList<>(k));
            return;
        }
        if (i == nums.length)
            return;
        if (nums[i] <= t) {
            k.add(nums[i]);
            func(nums, t - nums[i], i, k);
            k.remove(k.size() - 1);
        }
        func(nums, t, i + 1, k);
    }
}
