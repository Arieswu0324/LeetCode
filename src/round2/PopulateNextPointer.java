package round2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PopulateNextPointer {

    public Node connect2(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> layer = new ArrayList<>();

            while (size > 0) {
                Node node = queue.removeFirst();
                size--;
                layer.add(node);

                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }

            for (int i = 0; i < layer.size() - 1; i++) {
                Node cur = layer.get(i);
                cur.next = layer.get(i + 1);
            }
        }

        return root;

    }

    public Node connect(Node root) {
        Node dummy = new Node();
        Node cur = root;
        Node pre;

        while (cur != null) {
            pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }

                cur = cur.next;
            }

            cur = dummy.next;
            dummy.next = null;

        }

        return root;

    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


}
