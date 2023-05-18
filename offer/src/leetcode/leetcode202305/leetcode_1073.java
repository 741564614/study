package leetcode.leetcode202305;

import java.util.*;

public class leetcode_1073 {
    public static void main(String[] args) {
        int base = -2;
        System.out.println(2 % base);
        System.out.println((-1) % base);
        System.out.println(3 % base);
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr1.length - 1, j = arr2.length - 1; i >= 0 || j >= 0; i--, j--) {
            int value = 0;
            if (i >= 0) {
                value += arr1[i];
            }
            if (j >= 0) {
                value += arr2[j];
            }
            list.add(value);
        }
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if (value == 2 || value == 3) {
                if (i + 1 == list.size()) {
                    list.add(-1);
                } else {
                    list.set(i + 1, list.get(i + 1) - 1);
                }
                list.set(i, value % (-2));
            } else if (value == -1) {
                if (i + 1 == list.size()) {
                    list.add(1);
                } else {
                    list.set(i + 1, list.get(i + 1) + 1);
                }
                list.set(i, 1);
            }
        }
        int index = list.size() - 1;
        while (index > 0 && list.get(index) == 0) {
            index--;
        }
        int[] ans = new int[index + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(index - i);
        }
        return ans;
    }

    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int i = arr1.length - 1, j = arr2.length - 1;
            int carry = 0;
            List<Integer> ans = new ArrayList<Integer>();
            while (i >= 0 || j >= 0 || carry != 0) {
                int x = carry;
                if (i >= 0) {
                    x += arr1[i];
                }
                if (j >= 0) {
                    x += arr2[j];
                }
                if (x >= 2) {
                    ans.add(x - 2);
                    carry = -1;
                } else if (x >= 0) {
                    ans.add(x);
                    carry = 0;
                } else {
                    ans.add(1);
                    carry = 1;
                }
                --i;
                --j;
            }
            while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
                ans.remove(ans.size() - 1);
            }
            int[] arr = new int[ans.size()];
            for (i = 0, j = ans.size() - 1; j >= 0; i++, j--) {
                arr[i] = ans.get(j);
            }
            return arr;
        }
    }
}
