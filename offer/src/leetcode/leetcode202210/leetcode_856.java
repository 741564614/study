package leetcode.leetcode202210;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode_856 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> temps = new Stack<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                temps.push(0);
            } else {
                if (temps.peek() == 0) {
                    temps.push(temps.pop() + 1);
                } else if (temps.peek() != 0) {
                    int temp = 0;
                    while (!temps.isEmpty() && temps.peek() != 0) {
                        temp += temps.pop();
                    }
                    if (!temps.isEmpty() && temps.peek() == 0) {
                        temps.pop();
                    }
                    temps.push(temp * 2);
                }
            }

        }
        while (!temps.isEmpty()) {
            ans += temps.pop();
        }
        return ans;
    }


    public int scoreOfParentheses02(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') d.addLast(0);
            else {
                int cur = d.pollLast();
                d.addLast(d.pollLast() + Math.max(cur * 2 , 1));
            }
        }
        return d.peekLast();
    }
}
