package round2;

public class RemoveNthFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }

        pre.next = slow.next;

        return dummy.next;
    }


}
