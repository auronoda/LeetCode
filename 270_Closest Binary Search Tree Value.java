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
    public int closestValue(TreeNode root, double target) {
        if (root.val == target) {
            return root.val;
        }
        else if (root.val < target) {
            if (root.right == null) {
                return root.val;
            }
            int right = closestValue(root.right, target);
            return Math.abs((long)right - target) < Math.abs((long)root.val - target)? right: root.val;
        }
        else {
            if (root.left == null) {
                return root.val;
            }
            int left = closestValue(root.left, target);
            return Math.abs((long)left - target) < Math.abs((long)root.val - target)? left: root.val;
        }
    }
}
