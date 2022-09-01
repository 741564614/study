package leetcode.leetcode202209;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode_1475 {
    public static void main(String[] args) {

    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> index = new Stack<>();
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!index.isEmpty() && prices[index.peek()] >= prices[i]) {
                result[index.peek()] = prices[index.pop()] - prices[i];
            }
            index.push(i);
        }
        while (!index.isEmpty()) {
            result[index.peek()] = prices[index.pop()];
        }
        return result;
    }
}
