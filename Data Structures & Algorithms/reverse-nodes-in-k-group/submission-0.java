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
    public ListNode reverseKGroup(ListNode head, int k) {
        int c = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            c += 1;
        }
        int n = c / k;
        ListNode curr = head;
        ListNode oldt = null;
        ListNode newh = null;
        while (n > 0) {
            n -= 1;
            ListNode prev = null;
            ListNode nn = curr;
            c = k;
            while (c > 0) {
                c -= 1;
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if (newh == null)
                newh = prev;
            if (oldt != null)
                oldt.next = prev;
            nn.next = curr;
            oldt = nn;
        }
        return newh;
    }
}
