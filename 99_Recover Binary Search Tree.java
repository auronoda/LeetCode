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
    TreeNode first = null, second = null, prev = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        } 
        inorder(root.left);
        if (prev != null) {
            if (first == null && prev.val > root.val) {
                first = prev;
            }
            if (first != null && prev.val > root.val) {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
