package leetcode.leetcode202210;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_817 {
    public int numComponents(ListNode head, int[] nums) {
        boolean[] check = new boolean[10050];
        for (int num : nums) {
            check[num] = true;
        }
        int ans = 0;
        boolean k = false;
        ListNode next = head;
        while (next != null) {
            if (!check[next.val] && k) {
                ans++;
                k = false;
            } else if (check[next.val]) {
                k = true;
            }
            next = next.next;
        }
        if (k) {
            ans++;
        }
        return ans;
    }
    public int numComponents02(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }
}
