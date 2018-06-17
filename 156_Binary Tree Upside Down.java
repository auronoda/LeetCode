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
    TreeNode newRoot = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        helper(root);
        return newRoot;
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }        
        if (root.left == null) {
            newRoot = root;
            return root;
        }
        else {
            TreeNode parent = helper(root.left);
            parent.left = root.right;
            parent.right = root;
            root.left = null;
            root.right = null;
            return root;
        }        
    }
}
