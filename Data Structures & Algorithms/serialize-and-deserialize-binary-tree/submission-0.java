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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> k = new ArrayList<>();
        preorder(root, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k.size(); i++) {
            sb.append(k.get(i));
            if (i != k.size() - 1)
                sb.append(",");
        } 
        return sb.toString();
    }
    public void preorder(TreeNode root, ArrayList<String> k) {
        if (root == null) {
            k.add(null);
            return;
        }
        k.add(Integer.toString(root.val));
        preorder(root.left, k);
        preorder(root.right, k);
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] k = data.split(",");
        return buildTree(k);
    }
    int idx = 0;
    public TreeNode buildTree(String[] k) {
        if (k[idx].equals("null")) {
            idx += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(k[idx]));
        idx += 1;
        node.left = buildTree(k);
        node.right = buildTree(k);
        return node;
    }
}
