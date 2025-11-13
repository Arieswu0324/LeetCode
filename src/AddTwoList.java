public class AddTwoList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = new ListNode(sum % 10);
                tail = head;
            } else {
                tail = new ListNode(sum % 10);
                carry = sum / 10;
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoList instance = new AddTwoList();
        ListNode l1 = new ListNode(9);
        ListNode p = l1;

        int count = 6;
        while (count-- > 0) {
            l1.next = new ListNode(9);
            l1 = l1.next;
        }

        ListNode l2 = new ListNode(9);
        ListNode q = l2;
        count = 3;
        while (count-- > 0) {
            l2.next = new ListNode(9);
            l2 = l2.next;
        }

        ListNode res = instance.addTwoNumbers(p, q);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
