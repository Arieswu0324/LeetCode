import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(){}
        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    int capacity;

    Map<Integer, Node> map;

    Node start;
    Node end;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        start = new Node();
        end = new Node();
        start.next = end;
        end.pre = start;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        //更新LRU
        remove(node);
        addToLast(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            //更新LRU
            remove(node);
            addToLast(node);
            map.put(key, node);
        } else {
            if (map.size() < capacity) {
                Node node = new Node(key, value);
                map.put(key, node);
                addToLast(node);
            } else {
                removeFirst();
                Node node = new Node(key, value);
                map.put(key, node);
                addToLast(node);
            }
        }
    }

    private void removeFirst() {
        Node node = start.next;
        start.next = node.next;
        node.next.pre = start;
        map.remove(node.key);
    }

    private void remove(Node node) {
        if (node == null) {
            return;
        }
        Node pre = node.pre;
        pre.next = node.next;
        Node next = node.next;
        next.pre = node.pre;
    }

    private void addToLast(Node node) {
        if (node == null) {
            return;
        }
        Node last = end.pre;
        last.next = node;
        node.next = end;
        node.pre = last;
        end.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
