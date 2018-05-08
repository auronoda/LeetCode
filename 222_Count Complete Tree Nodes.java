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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return l == r? (1 << l) + countNodes(root.right): (1 << r) + countNodes(root.left);
    }
    
    private int getHeight(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        return getHeight(cur.left) + 1;
    }
}
