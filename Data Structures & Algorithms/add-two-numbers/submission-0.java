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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int counter = 0;
        ListNode k = new ListNode(-1);
        ListNode ans = k;
        while (l1 != null && l2 != null) {
            int p = l1.val + l2.val + counter;
            int nn = p % 10;
            counter = p / 10;
            k.next = new ListNode(nn);
            k = k.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int p = l1.val + counter;
            int nn = p % 10;
            counter = p / 10;
            k.next = new ListNode(nn);
            k = k.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int p = l2.val + counter;
            int nn = p % 10;
            counter = p / 10;
            k.next = new ListNode(nn);
            k = k.next;
            l2 = l2.next;
        }
        if (counter == 1) {
            k.next = new ListNode(1);
            k = k.next;
            k.next = null;
        }
        return ans.next;
    }
}
