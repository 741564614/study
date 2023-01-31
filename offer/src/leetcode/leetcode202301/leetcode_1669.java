package leetcode.leetcode202301;

import leetcode.ListNode;

public class leetcode_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode root = list1;
        ListNode aPerv = list1;
        ListNode tLast = list2;
        while (a > 0) {
            aPerv = list1;
            list1 = list1.next;
            a--;
            b--;
        }

        while (b > 0) {
            list1 = list1.next;
            b--;
        }

        while (tLast.next != null) {
            tLast = tLast.next;
        }

        aPerv.next = list2;
        tLast.next = list1.next;

        return root;
    }
}
