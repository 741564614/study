package leetcode.leetcode202208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetcode_658 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        System.out.println(findClosestElements2(arr, 3, 5));
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1, n = arr.length;
        LinkedList<Integer> result = new LinkedList<>();
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        r = r + 1 < n && Math.abs(arr[r] - x) > Math.abs(arr[r + 1] - x) ? r + 1 : r;
        int i = r - 1, j = r + 1;
        while (j - i - 1 < k) {
            if (i >= 0 && j < n) {
                if (Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) {
                    j++;
                } else {
                    i--;
                }
            } else if (i >= 0) {
                i--;
            } else {
                j++;
            }
        }
        for (int p = i + 1; p <= j - 1; p++) {
            result.add(arr[p]);
        }
        return result;
    }

    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}
