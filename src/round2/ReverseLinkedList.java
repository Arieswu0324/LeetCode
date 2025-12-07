package round2;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReverseLinkedList instance = new ReverseLinkedList();
        System.out.println(instance.reverseList(node1).val);
    }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        head.next=null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }
}
