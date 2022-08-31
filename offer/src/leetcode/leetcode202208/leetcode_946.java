package leetcode.leetcode202208;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode_946 {
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0, n = pushed.length;
        while (j < n) {
            while (j < n && !stack.isEmpty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
            if (i < n) {
                stack.push(pushed[i++]);
            }
            if (i >= n && !stack.isEmpty() && !stack.peek().equals(popped[j])) {
                break;
            }
        }
        return j == n;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            d.addLast(pushed[i]);
            while (!d.isEmpty() && d.peekLast() == popped[j] && ++j >= 0) d.pollLast();
        }
        return d.isEmpty();
    }
}
