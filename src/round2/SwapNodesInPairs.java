package round2;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // prev 指针永远指向“待交换的一对节点”的前一个节点
        ListNode prev = dummy;

        while(prev.next!=null && prev.next.next!=null){
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;

            ListNode next = node2.next;

            prev.next = node2;
            node2.next = node1;
            node1.next = next;

            prev = node1;
        }

        return dummy.next;
    }
}
