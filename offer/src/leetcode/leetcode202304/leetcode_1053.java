package leetcode.leetcode202304;

import java.util.Arrays;

public class leetcode_1053 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 5};
        System.out.println(Arrays.toString(new leetcode_1053().prevPermOpt1(arr)));
    }

    public int[] prevPermOpt1(int[] arr) {
        int i = 0;
        for (int k = arr.length - 1; k > 0; k--) {
            if (arr[k] < arr[k - 1]) {
                i = k - 1;
                break;
            }
        }
        if (i == 0 && (arr.length == 1 || arr[i] <= arr[i + 1])) {
            return arr;
        }
        int j = i + 1;
        for (int k = i + 1; k < arr.length; k++) {
            if (arr[k] > arr[j] && arr[k] < arr[i]) {
                j = k;
            }
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int n = arr.length;
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int j = n - 1;
                    while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                        j--;
                    }
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
            return arr;
        }
    }


}
