package leetcode.leetcode202307;

import leetcode.ListNode;

public class leetcode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (slow != null) {
                slow = slow.next;
            }
            if (fast != null) {
                fast = fast.next != null ? fast.next.next : null;
            }
            if (slow == null || fast == null) {
                return false;
            }
        } while (slow != fast);
        return true;
    }
}
