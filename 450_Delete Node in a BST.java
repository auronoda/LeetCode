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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            root.val = tmp.val;
            root.left = deleteNode(root.left, tmp.val);
            return root;
        }
        TreeNode tmp = root.right;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        root.val = tmp.val;
        root.right = deleteNode(root.right, tmp.val);
        return root;
        
    }
}
