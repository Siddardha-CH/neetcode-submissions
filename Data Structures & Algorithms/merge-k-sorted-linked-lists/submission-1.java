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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // for (int i = 1; i < lists.length; i++) 
        //     lists[i] = func(lists[i], lists[i - 1]);
        // return lists[lists.length - 1];



        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode i : lists)
            if (i != null)
                pq.offer(i);
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            node = node.next;
            if (node != null)
                pq.offer(node);
        }
        return ans.next;
    }

    // public ListNode func(ListNode a, ListNode b) {
    //     ListNode dummy = new ListNode(0);
    //     ListNode temp = dummy;
    //     while (a != null && b != null) {
    //         if (a.val > b.val) {
    //             temp.next = b;
    //             b = b.next;
    //         }
    //         else {
    //             temp.next = a;
    //             a = a.next;
    //         }
    //         temp = temp.next;
    //     }
    //     if (a != null) 
    //         temp.next = a;
    //     if (b != null)
    //         temp.next = b;
    //     return dummy.next;
    // }
}
