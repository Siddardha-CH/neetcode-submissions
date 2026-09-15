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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        dfs(root);
        return ans;
    }
     public int dfs (TreeNode node) {
        if (node == null)
            return 0;
        int lmax = Math.max(dfs(node.left), 0);
        int rmax = Math.max(dfs(node.right), 0);
        ans = Math.max(ans, node.val + lmax + rmax);
        return node.val + Math.max(lmax, rmax);
     }
}
