package leetcode.leetcode202305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_2455 {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return sum == 0 ? 0 : sum / count;
    }
}
