/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node t = head;
        while (t != null) {
            map.put(t, new Node(t.val));
            t = t.next;
        }
        t = head;
        while (t != null) {
            Node curr = map.get(t);
            curr.next = map.get(t.next);
            curr.random = map.get(t.random);
            t = t.next;
        }
        return map.get(head);
    }
}
