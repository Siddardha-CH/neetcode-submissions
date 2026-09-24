class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        func(nums, target, 0, new ArrayList<>());
        return ans;   
    }
    public void func(int[] nums, int t, int i, ArrayList<Integer> k) {
        if (t == 0) {
            ans.add(new ArrayList<>(k));
            return;
        }
        if (i == nums.length)
            return;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > t)
                break;
            if (j > i && nums[j] == nums[j - 1])
                continue;
            k.add(nums[j]);
            func(nums, t - nums[j], j + 1, k);
            k.remove(k.size() - 1);
        }
    }
}
