package leetcode.leetcode202211;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_1106 {
    public static void main(String[] args) {
        System.out.println(new leetcode_1106().parseBoolExpr("&(|(f))"));
    }

    int index = 0;

    public boolean parseBoolExpr02(String expression) {


        if (expression.charAt(index) == 't') {
            index++;
            return true;
        }
        if (expression.charAt(index) == 'f') {
            index++;
            return false;
        }
        if (expression.charAt(index) == '!') {
            index += 2;
            boolean t = parseBoolExpr02(expression);
            index++;
            return !t;
        }
        if (expression.charAt(index) == '&') {
            boolean t = true;
            index++;
            do {
                index++;
                t &= parseBoolExpr02(expression);
            }
            while (expression.charAt(index) == ',');
            index++;
            return t;
        }
        if (expression.charAt(index) == '|') {
            boolean t = false;
            index++;
            do {
                index++;
                t |= parseBoolExpr02(expression);
            }
            while (expression.charAt(index) == ',');
            index++;
            return t;
        }
        return false;
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '!' || c == '|' || c == '&' || c == 't' || c == 'f') {
                stack.push(c);
            } else if (c == ')') {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    list.add(stack.pop());
                }
                stack.push(count(list, stack.pop()));
            }
        }
        return stack.peek() == 't';
    }

    public char count(List<Character> list, char type) {
        switch (type) {
            case '!':
                return change(!change(list.get(0)));
            case '|':
                boolean temp = change(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    temp |= change(list.get(i));
                }
                return change(temp);
            case '&':
                boolean temp2 = change(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    temp2 &= change(list.get(i));
                }
                return change(temp2);
        }
        return 't';
    }

    public boolean change(char a) {
        return a == 't';
    }

    public char change(boolean b) {
        return b ? 't' : 'f';
    }
}
