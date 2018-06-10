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
    public int findSecondMinimumValue(TreeNode root) {
        int res = getNext(root, root.val);
        return res == Integer.MAX_VALUE? -1: res;
    }
    
    private int getNext(TreeNode cur, int n) {
        if (cur == null) {
            return Integer.MAX_VALUE;
        }
        if (cur.val > n) {
            return cur.val;
        }
        
        return Math.min(getNext(cur.left, n), getNext(cur.right, n));
    }
}
