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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new LinkedList<>(), right = new LinkedList<>(), leaves = new LinkedList<>();
        preOrder(root, left, right, leaves, 0);        
        left.addAll(leaves);
        left.addAll(right);
        return left;
    }
    
    private void preOrder(TreeNode cur, List<Integer> left, List<Integer> right, List<Integer> leaves, int flag) {
        if (cur == null) {
            return;
        }
        if (flag == 0) {
            left.add(cur.val);
            preOrder(cur.left, left, right, leaves, 1);
            preOrder(cur.right, left, right, leaves, 2);
        }
        else if (flag == 1) {
            left.add(cur.val);
            if (cur.left != null) {
                preOrder(cur.left, left, right, leaves, 1);
                preOrder(cur.right, left, right, leaves, 3);
            }
            else {
                preOrder(cur.right, left, right, leaves, 1);
            }
        }
        else if (flag == 2) {
            right.add(0, cur.val);
            if (cur.right != null) {
                preOrder(cur.left, left, right, leaves, 3);
                preOrder(cur.right, left, right, leaves, 2);
            }
            else {
                preOrder(cur.left, left, right, leaves, 2);
            }
        }
        else if (cur.left == null && cur.right == null) {
            leaves.add(cur.val);
        }
        else {
            preOrder(cur.left, left, right, leaves, 3);
            preOrder(cur.right, left, right, leaves, 3);
        }
    }
}
