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
        // ArrayList<Integer> list = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            // inorder(root);
            // for (int i = 1; i < list.size(); i++)
            //     if (list.get(i - 1) >= list.get(i))
            //         return false;
            //     return true;
            if (root == null)
                return true;
            if (!isValidBST(root.left))
                return false;
            if (root.val <= prev)
                return false;
            prev = root.val;
            return isValidBST(root.right);
        }
        // public void inorder(TreeNode node) {
        //     if (node == null)
        //         return;
        //     inorder(node.left);
        //     list.add(node.val);
        //     inorder(node.right);
        //     return;
        // }
    }
