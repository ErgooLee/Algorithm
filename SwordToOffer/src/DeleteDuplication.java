import java.util.ArrayList;

public class DeleteDuplication {
    public static ListNode main(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        pHead = new ListNode(0, pHead);
        ListNode r = pHead;
        ListNode p = pHead.next;
        ListNode q = pHead.next.next;
        boolean remove = false;
        while(q != null){
            if(p.val != q.val){
                if(remove){
                    r.next = q;
                    remove = false;
                    p = q;
                    q = q.next;
                }else{
                    r = r.next;
                    p = p.next;
                    q = q.next;
                }
            }else{
                 remove = true;
                 r.next = null;
                 p = q;
                 q = q.next;
            }
        }
        return pHead.next;
    }
}
