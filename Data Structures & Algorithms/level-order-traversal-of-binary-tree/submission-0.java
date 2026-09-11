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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> k = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (t != null) {
                    k.add(t.val);
                    q.add(t.left);
                    q.add(t.right);
                }
            } 
            if (k.size() > 0)
                ans.add(k);
        }
        return ans;
    }
}
