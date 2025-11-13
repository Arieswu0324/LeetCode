public class SwapNodesInPairs {
    public static ListNode swap(ListNode head){
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            ListNode a = cur.next;
            ListNode b = a.next.next;

            cur.next = cur.next.next;
            cur.next.next = a;
            a.next = b;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = swap(head);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
