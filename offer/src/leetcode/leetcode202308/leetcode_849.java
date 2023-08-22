package leetcode.leetcode202308;

public class leetcode_849 {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, max = 0, index = 0;
        while (index < seats.length) {
            if (seats[index] == 1) {
                max = Math.max(prev == -1 ? index : (index - prev) / 2, max);
                prev = index;
            }
            index++;
        }
        if(seats[index-1]==0){
            max = Math.max(prev == -1 ? index : (index-1 - prev), max);
        }
        return max;
    }
}
