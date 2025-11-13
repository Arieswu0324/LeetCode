public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        //双指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverse1(ListNode head) {
        //递归
        return recursion(head, null);
    }

    private static ListNode recursion(ListNode cur, ListNode pre) {
        if(cur == null){
            return pre;
        }//递归要有终止条件
        ListNode temp = cur.next;
        cur.next = pre;
        return recursion(temp, cur); //循环
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode res = reverse1(head);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
