package leetcode.leetcode202210;

public class leetcode_769 {

    public int maxChunksToSorted02(int[] arr) {
        int n = arr.length, ans = 0;
        for (int i = 0, j = 0, min = n, max = -1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (j == min && i == max) {
                ans++; j = i + 1; min = n; max = -1;
            }
        }
        return ans;
    }

    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        boolean[] check = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            check[arr[i]] = true;
            if (check(i, check)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean check(int end, boolean[] check) {
        for (int i = 0; i <= end; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }
}
