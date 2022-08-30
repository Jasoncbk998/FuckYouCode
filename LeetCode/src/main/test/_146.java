import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    private Map<Integer, DlinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DlinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);

    }

    private void addToHead(DlinkedNode node) {
        node.prev=head;
        node.next=head.next;
        head.next=node;
        head.next.prev=node;
    }


    private void removeNode(DlinkedNode node) {
        node.prev.prev=node.next;
        node.next.prev=node.prev;
    }

}
