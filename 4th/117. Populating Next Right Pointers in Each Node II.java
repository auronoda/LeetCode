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
        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode tailC = head;
            TreeLinkNode tailN = dummy;
            while (tailC != null) {
                if (tailC.left != null) {
                    tailN.next = tailC.left;
                    tailN = tailN.next;
                }
                if (tailC.right != null) {
                    tailN.next = tailC.right;
                    tailN = tailN.next;
                }
                tailC = tailC.next;
            }
            head = dummy.next;
        }
    }
}
