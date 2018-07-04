/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode head = root;
        while (head.left != null) {
            TreeLinkNode tailC = head;
            TreeLinkNode tailN = new TreeLinkNode(0);
            while (tailC != null) {
                tailN.next = tailC.left;
                tailC.left.next = tailC.right;
                tailN = tailC.right;
                tailC = tailC.next;
            }
            head = head.left;
        }
    }
}
