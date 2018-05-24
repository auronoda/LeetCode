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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = dfs(root, sum);
        res += pathSum(root.left, sum) + pathSum(root.right, sum);
        
        return res;
    }
    
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = root.val == sum? 1:0;
        res += dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
        return res;
    }
}
