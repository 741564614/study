package offer;

import java.util.*;

public class offer_30 {
    public static void main(String[] args) {

    }

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> subStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            subStack = new Stack<>();
            subStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            subStack.push(Math.min(subStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            subStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return subStack.peek();
        }
    }

    class MinStack02 {

        Deque<Integer> stack;
        Deque<Integer> subStack;

        /**
         * initialize your data structure here.
         */
        public MinStack02() {
            stack = new LinkedList<>();
            subStack = new LinkedList<>();
            subStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            subStack.push(Math.min(subStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            subStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return subStack.peek();
        }
    }
}
