package leetcode.leetcode202307;

import leetcode.ListNode;

public class leetcode_143 {
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode root = head;
        while (root != null) {
            root = root.next;
            len++;
        }
        if (len == 1 || len == 2) {
            return;
        }
        int tail = len - len / 2;
        root=head;
        while (tail>0){
            root=root.next;
            tail--;
        }
        reverse(root);
        root=head;
        tail=len/2;
        while(tail>0){
            ListNode temp1=root.next;
            ListNode temp2=secondRoot.next;
            root.next=secondRoot;
            secondRoot.next=temp1;
            secondRoot=temp2;
            tail--;
            root=root.next.next;
        }
        root.next=null;
    }

    ListNode secondRoot;

    public ListNode reverse(ListNode root) {
        if (root.next == null) {
            secondRoot = root;
            return root;
        }
        ListNode newRoot = reverse(root.next);
        newRoot.next = root;
        return root;
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode mid = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = reverseList(l2);
            mergeList(l1, l2);
        }

        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        public void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_tmp;
            ListNode l2_tmp;
            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
    }

}
