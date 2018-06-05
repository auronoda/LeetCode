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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        TreeNode SumRoot = getSum(root);
        return getTilt(SumRoot);
    }
    
    private int getTilt(TreeNode root) {
        int left = 0; 
        int right = 0;
        int res = 0;
        if (root.left != null) {
            res += getTilt(root.left);
            left = root.left.val;
        }
        if (root.right != null) {
            res += getTilt(root.right);
            right = root.right.val;
        }
        return Math.abs(left - right) + res;
    }
    
    private TreeNode getSum(TreeNode root) {
        TreeNode res = new TreeNode(root.val);
        if (root.left != null) {
            res.left = getSum(root.left);
            res.val += res.left.val;
        }
        if (root.right != null) {
            res.right = getSum(root.right);
            res.val += res.right.val;
        }
        return res;
    }
}
