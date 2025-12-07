package round2;



public class MyLinkedList{

    ListNode dummyhead;
    int size;


    public MyLinkedList() {
        this.dummyhead = new ListNode();
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode p = dummyhead.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);

    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        ListNode pre = dummyhead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode node = new ListNode(val);
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pre = dummyhead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode node = pre.next;
        pre.next = node.next;
        node.next = null;

        size--;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

}