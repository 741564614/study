package leetcode.leetcode202308;

import leetcode.ListNode;

public class leetcode_24 {

    public static void main(String[] args) {
        ListNode root=ListNode.init(new int[]{1,2,3,4});
        System.out.println(new leetcode_24().swapPairs(root));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = new ListNode(-1), root = ans;
        root.next = head;
        while (root != null && root.next != null && root.next.next != null) {
            ListNode temp = root.next, next = root.next.next.next;
            root.next = root.next.next;
            root.next.next = temp;
            root.next.next.next=next;
            root = root.next.next;
        }
        return ans.next;
    }
}
