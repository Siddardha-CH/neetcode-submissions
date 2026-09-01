class Solution {
    public int findDuplicate(int[] nums) {
        int s = 0;
        int f = 0;
        while (true) {
            f = nums[nums[f]];
            s = nums[s];
            if (f == s)
                break;
        }
        s = 0;
        while (true) {
            s = nums[s];
            f =nums[f];
            if (s == f)
                return s;
        }
    }
}
