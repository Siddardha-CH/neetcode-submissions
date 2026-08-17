class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int mm = matrix[0].length;
        int l = 0;
        int r = n - 1;
        int k = 0;
        while (r >= l) {
            int m = (r - l) / 2 + l;
            if (matrix[m][0] > target)
                r = m - 1;
            else {
                k = m;
                l = m + 1;
            }
        }
        l = 0;
        r = mm - 1;
        while (r >= l) {
            int m = (r - l) /2 + l;
            if (matrix[k][m] == target)
                return true;
            else if (matrix[k][m] > target)
                r = m - 1;
            else
                l = m +1;
        }
        return false;
    }
}
