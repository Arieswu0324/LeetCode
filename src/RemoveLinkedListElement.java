public class RemoveLinkedListElement {
    public static ListNode remove(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode res = remove(head,2);
        ListNode node = res;
        if(node == null){
            System.out.println("[]");
        }else {
            while (node!= null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
}
