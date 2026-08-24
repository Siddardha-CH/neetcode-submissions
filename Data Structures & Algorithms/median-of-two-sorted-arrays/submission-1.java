class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int tot = n1 + n2;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int l = 0;
        int r = n1;
        while (r >= l) {
            int m1 = (l + r) / 2;
            int m2 = (tot + 1) / 2- m1;
            int l1, l2, r1, r2;
            if (m1 == 0)
                l1 = Integer.MIN_VALUE;
            else
                l1 = nums1[m1 - 1];
            if (m2 == 0)
                l2 = Integer.MIN_VALUE;
            else
                l2 = nums2[m2 - 1];
            if (m1 == n1)
                r1 = Integer.MAX_VALUE;
            else
                r1 = nums1[m1];
            if (m2 == n2)
                r2 = Integer.MAX_VALUE;
            else
                r2 = nums2[m2];
            if (l1 <= r2 && l2 <= r1) {
                if (tot % 2 == 0)
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else
                    return (double)Math.max(l1, l2);
            }
            else if (l1 > r2)
                r = m1 - 1;
            else
                l = m1 + 1;
        }
        return 0;
    }
}
