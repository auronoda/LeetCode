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
    int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int tmp = 0; 
        int res = 0;
        if (root.left != null && root.val == root.left.val) {
            tmp += left + 1;
            res = Math.max(res, left + 1);
        }
        if (root.right != null && root.val == root.right.val) {
            tmp += right + 1;
            res = Math.max(res, right + 1);
        }
        max = Math.max(max, tmp);
        return res;
    }
}
