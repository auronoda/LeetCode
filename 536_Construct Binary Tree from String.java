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
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        int num = 0;
        int minus = 1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (s.charAt(i - 1) != ')') {
                    TreeNode tmp = new TreeNode(num * minus);
                    if (cur.left == null) {
                        cur.left = tmp;
                    }
                    else {
                        cur.right = tmp;
                    }
                    stack.push(cur);
                    cur = tmp;
                    num = 0;
                    minus = 1;
                }
                if (c == ')') {
                    cur = stack.pop();
                }                
            }
            else if (c == '-') {
                minus *= -1;
            }
            else {
                num = num * 10 + (c - '0');
            }
        }
        if (num != 0) {
            return new TreeNode(num * minus);
        }
        return dummy.left;
    }
}
