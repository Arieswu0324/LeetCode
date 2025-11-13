public class RemoveNthNodeFromEndOfList {
    public static ListNode remove(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0; i<=n&&fast!=null; i++){
            fast = fast.next;
        }//fast 先走n+1

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }//slow 走到该移除结点的前一位

        slow.next = slow.next.next;


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
        ListNode res = remove(head,2);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
