package leetcode.leetcode202305;

import java.util.Arrays;

public class leetcode_1093 {

    public static void main(String[] args) {
        int[] count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(new leetcode_1093().sampleStats(count)));
    }

    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        ans[0] = 255;
        ans[1] = 0;
        long num = 0, sum = 0, max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                ans[0] = Math.min(ans[0], i);
                ans[1] = Math.max(ans[1], i);
                num += count[i];
                sum += ((long) count[i] * i);
                if (count[i] > max) {
                    ans[4] = i;
                    max = count[i];
                }
            }
        }
        ans[2] = (sum * 1.0) / num;
        int mid = 0, index = (int) (num / 2 + num % 2);
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                mid += count[i];
                if (mid > num / 2) {
                    ans[3] = i;
                    break;
                } else if (mid == index) {
                    int j = i + 1;
                    while (j < count.length && count[j] == 0) {
                        j++;
                    }
                    ans[3] = num % 2 != 0 ? i : (i + j) / 2.0;
                    break;
                }
            }
        }
        return ans;
    }
}
