/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode cur1 = dummy1, cur2 = dummy2;
        ListNode tail = head;
        while (tail != null) {
            ListNode next = tail.next;
            if (tail.val < x) {
                cur1.next = tail;
                cur1 = tail;
            }
            else {
                cur2.next = tail;
                cur2 = tail;
            }
            tail.next = null;
            tail = next;
        }
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
