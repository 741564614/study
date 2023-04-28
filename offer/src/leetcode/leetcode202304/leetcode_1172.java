package leetcode.leetcode202304;

import java.util.*;
import java.util.Stack;

public class leetcode_1172 {
    class DinnerPlates02 {
        // 栈的容量
        private int capacity;
        // 所有栈
        private List<Deque<Integer>> stacks = new ArrayList<>();
        // 最小堆，保存未满栈的下标
        private PriorityQueue<Integer> idx = new PriorityQueue<>();

        public DinnerPlates02(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (!idx.isEmpty() && idx.peek() >= stacks.size())
                idx.clear(); // 堆中都是越界下标，直接清空
            if (idx.isEmpty()) { // 所有栈都是满的
                var st = new ArrayDeque<Integer>();
                st.push(val);
                stacks.add(st); // 添加一个新的栈
                if (capacity > 1) // 新的栈没有满
                    idx.add(stacks.size() - 1); // 入堆
            } else { // 还有未满栈
                var st = stacks.get(idx.peek());
                st.push(val); // 入栈
                if (st.size() == capacity) // 栈满了
                    idx.poll(); // 从堆中去掉
            }
        }

        public int pop() {
            // 等价为 popAtStack 最后一个非空栈
            return popAtStack(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty())
                return -1; // 非法操作
            var st = stacks.get(index);
            if (st.size() == capacity) // 满栈
                idx.add(index); // 元素出栈后，栈就不满了，把下标入堆
            int val = st.pop();
            // 去掉末尾的空栈（懒删除，堆中下标在 push 时处理）
            while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty())
                stacks.remove(stacks.size() - 1);
            return val;
        }
    }

}
