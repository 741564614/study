package leetcode.leetcode202210;

import java.util.Arrays;

public class leetcode_927 {
    public int[] threeEqualParts02(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }
        int p = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                }
                if (cur == p) {
                    second = i;
                }
                if (cur == 2 * p) {
                    third = i;
                }
                cur++;
            }
        }

        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            for (int i = 0; i < len; i++) {
                if (arr[first + i] != arr[second + i] || arr[second + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }
}
