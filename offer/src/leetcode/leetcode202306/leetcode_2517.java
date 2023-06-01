package leetcode.leetcode202306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_2517 {

    public static void main(String[] args) {
        int[] arr = new int[]{34, 116, 83, 15, 150, 56, 69, 42, 26};
        System.out.println(new leetcode_2517().maximumTastiness02(arr, 6));
    }


    public int maximumTastiness02(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 0, r = price[n - 1] - price[0];
        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            if (check(price, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public boolean check(int[] price, int k, int target) {
        int perv = price[0];
        k--;
        for (int i : price) {
            if (i - perv >= target) {
                k--;
                perv = i;
            }
        }
        return k <= 0;
    }

}
