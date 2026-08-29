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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode r = head;
        ListNode l = fake;
        while (n > 0) {
            n -= 1;
            r = r.next;
        }
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return fake.next;
    }
}
