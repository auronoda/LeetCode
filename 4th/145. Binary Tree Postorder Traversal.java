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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode cur, List<Integer> res) {
        if (cur == null) {
            return;
        }        
        helper(cur.left, res);        
        helper(cur.right, res);
        res.add(cur.val);
    }
}
