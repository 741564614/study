package leetcode.leetcode202301;

import java.util.*;

public class leetcode_1801 {

    public static void main(String[] args) {
        int[][] orders = new int[][]{{27, 30, 0}, {10, 10, 1}, {28, 17, 1}, {19, 28, 0}, {16, 8, 1}, {14, 22, 0}, {12, 18, 1}, {3, 15, 0}, {25, 6, 1}};
        System.out.println(new leetcode_1801().getNumberOfBacklogOrders(orders));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        long mod = (long) (1e9 + 7);

        PriorityQueue<Long[]> buyList = new PriorityQueue<>((a, b) -> (int) (b[0] - a[0]));

        PriorityQueue<Long[]> sellList = new PriorityQueue<>((a, b) -> (int) (a[0] - b[0]));


        for (int[] order : orders) {
            //采购订单
            if (order[2] == 0) {
                while (!sellList.isEmpty() && order[1] > 0 && sellList.peek()[0] <= order[0]) {
                    Long[] sell = sellList.peek();
                    //销售订单被消耗完
                    if (order[1] >= sell[1]) {
                        order[1] -= sell[1];
                        sellList.poll();
                    }
                    //采购订单被消耗完
                    else {
                        sell[1] -= order[1];
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) {
                    buyList.offer(new Long[]{(long) order[0], (long) order[1]});
                }
            }
            //销售订单
            else {
                while (!buyList.isEmpty() && order[1] > 0 && buyList.peek()[0] >= order[0]) {
                    Long[] buy = buyList.peek();
                    //采购订单被消耗完
                    if(order[1]>=buy[1]){
                        order[1] -= buy[1];
                        buyList.poll();
                    }
                    //销售订单被消耗完
                    else{
                        buy[1] -= order[1];
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) {
                    sellList.offer(new Long[]{(long) order[0], (long) order[1]});
                }
            }
        }


        long ans=0L;

        for (Long[] order : buyList) {
            ans=(ans+order[1])%mod;
        }

        for (Long[] order : sellList) {
            ans=(ans+order[1])%mod;
        }

        return (int) ans;
    }
}
