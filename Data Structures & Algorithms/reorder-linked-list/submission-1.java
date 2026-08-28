/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = head;
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        ListNode k = null;
        while (slow != null) {
            ListNode t = slow;
            slow = slow.next;
            t.next = k;
            k = t;
        }
        boolean b = false;
        ListNode v1 = head;
        ListNode v2 = k;
        while (v2 != null) {
            ListNode t1 = v1.next;
            ListNode t2 = v2.next;
            v1.next = v2;
            if (t1 == null)
                break;
            v2.next = t1;
            v1 = t1;
            v2 = t2;
        }
        return;
    }
}
