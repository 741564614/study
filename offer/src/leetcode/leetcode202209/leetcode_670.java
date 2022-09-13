package leetcode.leetcode202209;

import java.util.ArrayList;
import java.util.List;

public class leetcode_670 {
    public static void main(String[] args) {

    }

    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        int len = String.valueOf(num).length();
        int[] note = new int[len], nums = new int[len];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
            note[len-i-1] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            note[i] = Math.max(nums[nums.length - i - 1], note[i - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < note[nums.length - i - 1]) {
                int def = nums[i];
                nums[i] = note[nums.length - i - 1];
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] == nums[i]) {
                        nums[j] = def;
                        break;
                    }
                }
                break;
            }
        }

        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += (nums[i] * Math.pow(10, len - i - 1));
        }
        return ans;
    }
    public int maximumSwap02(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10); num /= 10;
        }
        int n = list.size(), ans = 0;
        int[] idx = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            idx[i] = j;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (!list.get(idx[i]).equals(list.get(i))) {
                int c = list.get(idx[i]);
                list.set(idx[i], list.get(i));
                list.set(i, c);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) ans = ans * 10 + list.get(i);
        return ans;
    }

}
