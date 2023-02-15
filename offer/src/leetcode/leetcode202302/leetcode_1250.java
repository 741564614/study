package leetcode.leetcode202302;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class leetcode_1250 {
    public static void main(String[] args) {
        int[] k = new int[]{18, 18, 18, 15, 54, 45, 45, 45};

    }

    public boolean isGoodArray02(int[] nums) {
        int gcdNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcdNum = gcd(gcdNum, nums[i]);
            if (gcdNum == 1) {
                break;
            }
        }
        return gcdNum == 1;
    }

    public int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}
