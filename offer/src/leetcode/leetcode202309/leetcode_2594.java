package leetcode.leetcode202309;

import java.util.Arrays;

public class leetcode_2594 {
    public long repairCars02(int[] ranks, int cars) {
        long l = 0, r = (long) ranks[0] * cars * cars;
        while(l<r){
            long mid=l+(r-l)/2;
            long sum=get(mid,ranks);
            if(sum>=cars){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public long get(long time, int[] ranks) {
        long cnt = 0;
        for (int x : ranks) {
            cnt += (long) Math.sqrt(time / x);
        }
        return cnt;
    }
}
