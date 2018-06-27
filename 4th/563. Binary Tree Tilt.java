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
    int res = 0;
    public int findTilt(TreeNode root) {
        getSum(root);
        return res;
    }
    
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
