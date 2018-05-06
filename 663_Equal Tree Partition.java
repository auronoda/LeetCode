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
    public boolean checkEqualTree(TreeNode root) {

        
        TreeNode sumRoot = getSum(root);
        if (sumRoot.val % 2 != 0) {
            return false;
        }
        return dfs(sumRoot.left, sumRoot.val / 2) || dfs(sumRoot.right, sumRoot.val / 2);
    }
    
    private TreeNode getSum(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        TreeNode res = new TreeNode(cur.val);
        if (cur.left != null) {
            res.left = getSum(cur.left);
            res.val += res.left.val;
        }
        if (cur.right != null) {
            res.right = getSum(cur.right);
            res.val += res.right.val;
        }
        return res;
    }
    
    boolean dfs(TreeNode cur, int target){
        if (cur == null) {
            return false;
        }
        
        if (cur.val == target) {
            return true;
        }

        return dfs(cur.left, target) || dfs(cur.right, target);
    }
}
