package round2;

public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int m = 0;
        int n = 0;
        int delta = 0;

        ListNode p = headA;
        ListNode q = headB;

        while (p != null) {
            p = p.next;
            m++;
        }

        while (q != null) {
            q = q.next;
            n++;
        }

        delta = Math.abs(m - n);
        if (m > n) {
            for (int i = 0; i < delta; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                headB = headB.next;
            }

        }

        p = headA;
        q = headB;

        while (p != null && q != null) {
            if (p == q && p.val != 0) {
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }
}
