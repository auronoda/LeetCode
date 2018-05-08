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
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Integer prev = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; 
            }
            cur = stack.pop();
            if (prev != null) {
                res = Math.min(res, Math.abs(cur.val - prev));
            }            
            prev = cur.val;
            cur = cur.right;
        }
        return res;
    }
}
