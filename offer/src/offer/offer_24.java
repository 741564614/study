package offer;

import leetcode.ListNode;

public class offer_24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode listNode1 = new offer_24().reverseList(listNode);
        System.out.println("n");
    }

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归到尽头
        ListNode ans = reverseList(head.next);
        //掉头
        head.next.next = head;
        head.next = null;
        return ans;
    }

    //迭代
    public ListNode reverseList02(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            //掉头
            curr.next=prev;
            //移动
            prev=curr;
            curr=next;
        }
        return prev;
    }

}
