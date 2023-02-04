package leetcode.leetcode202302;

import java.util.*;

public class leetcode_1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 0;
        int index = 0;
        while (index < coins.length && coins[index] <= max + 1) {
            max += coins[index];
            index++;
        }

        return max+1;
    }
}
