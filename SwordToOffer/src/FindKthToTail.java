/**
 * Created by lichao on 18/07/2017.
 * 题目描述输入一个链表，
 * 输出该链表中倒数第k个结点。
 * 第一指针先走k-1步
 * 第一个指针和第二个指针同时移动，当第一个到底部时，第二个指针指的就是倒数第k个。
 */

class ListNode {

    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

//    public static ListNode node42 = new ListNode(4);
//    public static ListNode node41 = new ListNode(4, node42);
//    public static ListNode node32 = new ListNode(3, node41);
//    public static ListNode node31 = new ListNode(3, node32);
//    public static ListNode node22 = new ListNode(2, node31);
//    public static ListNode node21 = new ListNode(2, node22);
//    public static ListNode node12 = new ListNode(1, node21);
//    public static ListNode pHead = new ListNode(1, node12);
    public static ListNode node7 = new ListNode(7);
    public static ListNode node6 = new ListNode(6, node7);


    public static ListNode node5 = new ListNode(5, node6);
    public static ListNode node4 = new ListNode(4, node5);

    public static ListNode node3 = new ListNode(3, node6);
    public static ListNode node2 = new ListNode(2, node3);
    public static ListNode node1 = new ListNode(1, node2);




}
public class FindKthToTail {

    public static ListNode FindKthToTail(ListNode head,int k) {
        int count = k - 1;
        ListNode p = head;
        ListNode result = head;
        while(p != null && count > 0){
            p = p.next;
            count --;
        }

        if(p == null || k == 0)
            return null;
        while(p.next != null){
            result = result.next;
            p = p.next;
        }
        return result;

    }

}
