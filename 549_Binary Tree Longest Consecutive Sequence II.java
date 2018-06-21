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
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        Arrays.fill(res, 1);
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int lr = 1;
        int rl = 1;
        if (root.left != null) {
            if (root.val == root.left.val - 1) {
                res[0] = Math.max(res[0], 1 + left[0]);
                rl += left[0];
            }
            if (root.val == root.left.val + 1) {
                res[1] = Math.max(res[1], 1 + left[1]);
                lr += left[1];
            }
        }
        
        if (root.right != null) {
            if (root.val == root.right.val - 1) {
                res[0] = Math.max(res[0], 1 + right[0]);
                lr += right[0];
            }
            if (root.val == root.right.val + 1) {
                res[1] = Math.max(res[1], 1 + right[1]);
                rl += right[1];
            }
        }
        max = Math.max(max, lr);
        max = Math.max(max, rl);
        return res;
    }
}
