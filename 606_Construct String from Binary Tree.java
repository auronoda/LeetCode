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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        sb.append('(');
        sb.append(tree2str(t.left));
        sb.append(")");
        if (t.right != null) {
            sb.append('(');
            sb.append(tree2str(t.right));
            sb.append(')');
        }
        return sb.toString();
    }
}
