public class IntersectionOfTwoLinkedLists {
    public ListNode findIntersection(ListNode headA, ListNode headB){
        int lenA=0;
        int lenB=0;
        int k=0;
        ListNode intersection=null;

        ListNode p = headA;
        ListNode q = headB;
        while(p!=null){
            p = p.next;
            lenA++;
        }
        while(q!=null){
            q = q.next;
            lenB++;
        }
        p = headA;
        q= headB;
         k = lenA - lenB;
        if(k>0){
            while(k>0){
                p = p.next;
                k--;
            }
        }else{
            while(k<0){
                q = q.next;
                k++;
            }
        }

        while(p!=null){
            if(p==q){
                intersection = p;
                break;
            }
            p = p.next;
            q= q.next;
        }
        return intersection;
    }

}
