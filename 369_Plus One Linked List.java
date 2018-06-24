/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.val < 9) {
                slow = fast;
            }
        }
        
        if (fast.val < 9) {
            fast.val++;
            return dummy.next;
        }
        fast.val = 0;
        while (slow != fast) {
            slow.val = (slow.val + 1) % 10;
            slow = slow.next;
        }
        
        return dummy.val == 0? dummy.next: dummy;
    }
}
