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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (list.get(start) + list.get(end) == k) {
                return true;
            }
            if (list.get(start) + list.get(end) < k) {
                start++;
            }
            else {
                end--;
            }
        }
        return false;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
