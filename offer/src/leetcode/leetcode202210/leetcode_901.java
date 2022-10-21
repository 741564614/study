package leetcode.leetcode202210;

import java.util.*;

public class leetcode_901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
        stockSpanner.next(75);
        stockSpanner.next(85);
    }

    static class StockSpanner {
        Stack<int[]> stack;

        public StockSpanner() {
            stack=new Stack<>();
        }

        public int next(int price) {
            int ans=1;
            while(!stack.isEmpty()&&stack.peek()[0]<=price){
                ans+=stack.pop()[1];
            }
            stack.push(new int[]{price,ans});
            return ans;
        }
    }

}
