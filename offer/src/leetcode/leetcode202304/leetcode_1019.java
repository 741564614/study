package leetcode.leetcode202304;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_1019 {
    public static void main(String[] args) {
        int[] values = new int[]{2, 7, 4, 3, 5};
        ListNode root = ListNode.init(values);
        System.out.println(Arrays.toString(new leetcode_1019().nextLargerNodes(root)));
    }

    public int[] nextLargerNodes(ListNode head) {
        LinkedList<int[]> stack = new LinkedList<>();
        ListNode root = head;
        int n = 0;
        while (root != null) {
            n++;
            root = root.next;
        }
        int[] ans = new int[n];
        for (int i = 0; head != null; i++) {
            while (!stack.isEmpty() && head.val > stack.peek()[0]) {
                ans[stack.poll()[1]] = head.val;
            }
            stack.addFirst(new int[]{head.val, i});
            head = head.next;
        }
        return ans;
    }
}
