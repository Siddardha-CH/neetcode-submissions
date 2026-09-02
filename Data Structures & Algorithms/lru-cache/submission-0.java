public class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node (int key, int val) {
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int size;
    HashMap<Integer, Node> map;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node (0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        }
        else {
            if (map.size() == size) {
                Node last = right.prev;
                remove(last);
                map.remove(last.key);
            }
            Node nn = new Node(key, value);
            insert(nn);
            map.put(key, nn);
        }
    }
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node) {
        node.next = left.next;
        node.prev = left;
        left.next.prev = node;
        left.next = node;
    }
}
