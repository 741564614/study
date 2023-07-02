package leetcode.leetcode202307;

import leetcode.ListNode;

public class leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1, head2 = l2;
        while (head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 == null) {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
            head1 = head2;
        }

        ListNode root = l1;
        int j = 0;
        ListNode prev = l1;
        while (l1 != null || j != 0) {
            if (l1 != null) {
                int value = l1.val + (l2 != null ? l2.val : 0) + j;
                l1.val = value % 10;
                j = value / 10;
                prev = l1;
                l1 = l1.next;
                if (l2 != null) {
                    l2 = l2.next;
                }
            } else {
                prev.next = new ListNode(j);
                j = 0;
            }
        }
        return root;
    }
}
