public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int start = size - k % size;
        cur = head;
        ListNode pre = dummy;
        while (start > 0) {
            cur = cur.next;
            pre = pre.next;
            start--;
        }

        head = cur;
        pre.next = null;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = dummy.next;

        return head;

    }
}
