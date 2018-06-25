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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        int start = 0, end = vals.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((long)vals.get(mid) - target > 0) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        int left = Math.abs((long)vals.get(start) - target) < Math.abs((long)vals.get(end) - target)? start: end;
        int right = left;
        while (right - left + 1 < k) {
            if (left == 0) {
                right++;
            }
            else if (right == vals.size() - 1 || 
                     Math.abs((long)vals.get(left - 1) - target) < Math.abs((long)vals.get(right + 1) - target)) {
                left--;
            }
            else {
                right++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            res.add(vals.get(i));
        }
        return res;
    }
    
    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
