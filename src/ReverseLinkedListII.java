public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode front = null;
        ListNode tail;

        ListNode cur = new ListNode();
        cur.next = head;
        int count = 1;

        while (count < right) {
            if (count == left - 1) {
                front = cur;

                cur = cur.next;
                count++;
            }
        }
        tail = cur.next;
        cur.next = null;//把right 后面指向null
        ListNode temp;
        if (front == null) {
            temp = head;
        } else {
            temp = front.next;
        }
        ListNode reversed = reverse(temp);
        temp.next = tail;
        if (front == null) {
            return reversed;
        } else {
            front.next = reversed;
            return head;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!= null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
