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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode k1 = list1;
        ListNode k2 = list2;
        ListNode t = ans;
        while (k1 != null && k2 != null) {
            if (k1.val > k2.val) {
                t.next = k2;
                k2 = k2.next;
            }
            else {
                t.next = k1;
                k1 = k1.next;
            }
            t = t.next;
        }
        while (k1 != null) {
            t.next = k1;
            k1 = k1.next;
            t = t.next;
        }
        while (k2 != null) {
            t.next = k2;
            k2 = k2.next;
            t = t.next;
        }
        return ans.next;
    }
}