package leetcode.leetcode202211;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leetcode_895 {
}

class FreqStack02 {
    Map<Integer, Integer> freqMap;
    Map<Integer, Deque<Integer>> stackMap;
    int max;

    public FreqStack02() {
        max = 0;
        freqMap = new HashMap<>(16);
        stackMap = new HashMap<>(16);
    }

    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        Integer index = freqMap.get(val);
        max = Math.max(max, index);
        stackMap.put(index, stackMap.getOrDefault(index, new LinkedList<>()));
        stackMap.get(index).push(val);
    }

    public int pop() {
        Integer pop = stackMap.get(max).pop();
        freqMap.put(pop, freqMap.get(pop) - 1);
        if (stackMap.get(max).isEmpty()) {
            max--;
        }
        return pop;
    }
}