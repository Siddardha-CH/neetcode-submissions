class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        func(nums, 0, new ArrayList<>());
        return ans;
    }
    public void func(int[] nums, int i, ArrayList<Integer> k) {
        ans.add(new ArrayList<>(k));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            k.add(nums[j]);
            func(nums, j + 1, k);
            k.remove(k.size() - 1);
        }
    }
}
