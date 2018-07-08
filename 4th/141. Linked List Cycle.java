/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy.next, slow = dummy;
        while (fast != slow && (fast != null && fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }
}
