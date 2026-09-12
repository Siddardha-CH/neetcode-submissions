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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root ,0);
        return ans;
    }
    public void dfs(TreeNode node, int d) {
        if (node == null)
            return;
        if (d == ans.size())
            ans.add(node.val);
        d += 1;
        dfs(node.right, d);
        dfs(node.left, d);
    }
}
