/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int ans = dfs(root, root.val);
        return ans;
    }
    public int dfs (TreeNode root, int max) {
        if (root == null)
            return 0;
        int k = 0;
        if (root.val >= max)
            k = 1;
        max = Math.max(max, root.val);
        k += dfs(root.left, max);
        k += dfs(root.right, max);
        return k;
    }
}
