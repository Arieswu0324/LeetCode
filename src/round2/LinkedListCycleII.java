package round2;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//相遇
                ListNode meet = fast;

                ListNode p = head;
                ListNode q = meet;

                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }

        return null;

    }
}
