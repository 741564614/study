package offer;

import leetcode.ListNode;

public class offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode next = head;
        while (k > 0 && next != null) {
            next = next.next;
            k--;
        }
        while (next != null) {
            head = head.next;
            next = next.next;
        }
        return head;
    }
}
