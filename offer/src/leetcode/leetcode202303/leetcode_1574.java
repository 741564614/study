package leetcode.leetcode202303;

public class leetcode_1574 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 10, 21, 37, 34, 17, 23, 18, 14, 6, 26, 26, 28, 40, 26, 20, 33, 29, 4, 17};
        System.out.println(arr.length);
        System.out.println(new leetcode_1574().findLengthOfShortestSubarray(arr));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, n = arr.length;
        while (l < n - 1 && arr[l + 1] >= arr[l]) {
            l++;
        }
        if (l == n - 1) {
            return 0;
        }
        int r = l;
        for (int i = l + 1; i < n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                r = i;
            }
        }
        int nl = l, nr = r;
        while (nl > 0 && nr < n - 1 && arr[nl - 1] > arr[nr + 1]) {
            nl--;
            nr++;
        }
        while (nl <= l && (nr == n - 1 || arr[nr + 1] >= arr[nl])) {
            nl++;
        }
        while (nr > r && (nl == 0 || arr[nl - 1] <= arr[nr])) {
            nr--;
        }
        return Math.min(nr - nl + 1, Math.min(n - l - 1, r + 1));
    }

    public int findLengthOfShortestSubarray02(int[] arr) {
        int l = 0, n = arr.length, r = n - 1;
        while (l < n - 1 && arr[l + 1] >= arr[l]) {
            l++;
        }
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        if (l >= r) {
            return 0;
        }
        int ans = Math.min(n - l - 1, r);
        for (int i = 0; i <= l; i++) {
            int res = findLeftBorder(arr, arr[i], r);
            ans = Math.min(ans, res - i - 1);
        }
        return ans;
    }

    public int findLeftBorder(int[] arr, int target, int left) {
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
