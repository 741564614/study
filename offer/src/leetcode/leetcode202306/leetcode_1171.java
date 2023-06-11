package leetcode.leetcode202306;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class leetcode_1171 {

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, -3, -2};
        ListNode root = ListNode.init(values);
        System.out.println(new leetcode_1171().removeZeroSumSublists(root));
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dy = new ListNode(0);
        dy.next=head;
        int prefix = 0;
        for (ListNode root = dy; root != null; root = root.next) {
            prefix += root.val;
            map.put(prefix, root);
        }

        prefix = 0;
        for (ListNode root = dy; root != null; root = root.next) {
            prefix += root.val;
            root.next = map.get(prefix).next;
        }
        return dy.next;
    }


}
