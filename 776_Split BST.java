/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (V > root.val) {
            TreeNode[] tmp = splitBST(root.right, V);
            res[0] = root;
            root.right = tmp[0];
            res[1] = tmp[1];
            return res;
        }
        else if (V < root.val) {
            TreeNode[] tmp = splitBST(root.left, V);
            res[0] = tmp[0];
            root.left = tmp[1];
            res[1] = root;
            return res;
        }
        TreeNode right = root.right;
        root.right = null;
        res[0] = root;
        res[1] = right;
        return res;
    }
}
