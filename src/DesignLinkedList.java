public class DesignLinkedList {
    int size;
    ListNode head;

    public DesignLinkedList() {
        this.size = 0;
        this.head = new ListNode();//虚拟头结点
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        ListNode cur = head;
        while (index >= 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }


    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head.next;
        this.head.next = newNode; //这里如果head=newNode的话虚拟节点就消失了
        size++;

    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size ) { //这里不要index> size-1，因为如果当前size = 3,
            // index目前虽然到2，但是可以加index=3的元素，为尾元素
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;
    }

    public static void main(String[] args) {
       DesignLinkedList myLinkedList = new DesignLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3,0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        System.out.println( myLinkedList.get(4) );
        myLinkedList.addAtHead(4);// return 2
        myLinkedList.addAtIndex(5,0);
        myLinkedList.addAtHead(6);// return 3

    }

}
