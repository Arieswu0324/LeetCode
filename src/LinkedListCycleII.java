public class LinkedListCycleII {
    public static ListNode cycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode intersection = fast;
                ListNode start = head;

                while(intersection!=start){
                    intersection = intersection.next;
                    start = start.next;
                }
                return intersection;
            }
        }
        return null;
    }


    public static ListNode findIntersection(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode intersection = null;
        while(fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                intersection = fast;
                break;
            }
        }
        return intersection;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(findIntersection(head).val);
        //ListNode intersection = cycle(head);
        //System.out.println(intersection == null ? null : intersection.val);
    }


}
