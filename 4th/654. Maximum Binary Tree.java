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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = nums[start], idx = start;
        for (int i = start; i <= end; ++i) {
            if (nums[i] > max) {
                idx = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, start, idx - 1);
        root.right = helper(nums, idx + 1, end);
        return root;
    }
}
