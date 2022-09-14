package leetcode.leetcode202209;

import java.util.Arrays;

public class leetcode_1619 {
    public static void main(String[] args) {

    }

    public double trimMean(int[] arr) {
        int price = (int) (arr.length * 0.05);
        int sum = 0;
        Arrays.sort(arr);
        for (int i = price; i < arr.length - price; i++) {
            sum += arr[i];
        }
        return sum / (arr.length * 0.9);
    }
}
