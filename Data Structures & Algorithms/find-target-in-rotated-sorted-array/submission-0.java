class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (r > l) {
            int m = (r - l) / 2 + l;
            if (nums[m] > nums[r])
                l = m + 1;
            else 
                r = m;
        }
        int st = l;
        if (nums[nums.length - 1] < target) {
            l = 0;
            r = st - 1;
        }
        else {
            l = st;
            r = nums.length - 1;
        }
        while (r >= l) {
            int m = (r - l) /2 + l;
            if (nums[m] == target)
                return m;
            if (nums[m] > target)
                r = m -1;
            else
                l = m + 1;
        }
        return -1;
    }
}
