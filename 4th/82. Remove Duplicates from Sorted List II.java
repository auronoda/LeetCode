/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                while (fast.next != null && fast.next.val == fast.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                slow.next = fast;
            }
            else {
                slow = fast;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
