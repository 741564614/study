package leetcode.leetcode202301;

public class leetcode_1664 {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 1, 6, 4};
        System.out.println(new leetcode_1664().waysToMakeFair(ints));
    }

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[][] suffix = new int[2][n];
        for (int i = n - 1; i >= 0; i--) {
            if ((i & 1) == 0) {
                suffix[1][i] = i == n - 1 ? 0 : suffix[1][i + 1];
                suffix[0][i] = i == n - 1 ? nums[i] : suffix[0][i + 1] + nums[i];
            } else {
                suffix[1][i] = i == n - 1 ? nums[i] : suffix[1][i + 1] + nums[i];
                suffix[0][i] = i == n - 1 ? 0 : suffix[0][i + 1];
            }
        }

        int ans = 0;
        int[] prefix = new int[2];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                if (prefix[0] + suffix[1][i] == prefix[1] + (suffix[0][i] - nums[i])) {
                    ans++;
                }
                prefix[0] += nums[i];
            } else {
                if (prefix[1] + suffix[0][i] == prefix[0] + (suffix[1][i] - nums[i])) {
                    ans++;
                }
                prefix[1] += nums[i];
            }
        }

        return ans;
    }


    public int waysToMakeFair20(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            if ((i & 1) == 0) {
                suffix[0] += nums[i];
            } else {
                suffix[1] += nums[i];
            }
        }

        int ans = 0;
        int[] prefix = new int[2];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                suffix[0] -= nums[i];
                if (prefix[0] + suffix[1] == prefix[1] + suffix[0]) {
                    ans++;
                }
                prefix[0] += nums[i];
            } else {
                suffix[1] -= nums[i];
                if (prefix[1] + suffix[0] == prefix[0] + suffix[1]) {
                    ans++;
                }
                prefix[1] += nums[i];
            }
        }

        return ans;
    }


    public int waysToMakeFair02(int[] nums) {
        int odd1 = 0, even1 = 0;
        int odd2 = 0, even2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 += nums[i];
            } else {
                even2 += nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 -= nums[i];
            } else {
                even2 -= nums[i];
            }
            if (odd1 + even2 == odd2 + even1) {
                ++res;
            }
            if ((i & 1) != 0) {
                odd1 += nums[i];
            } else {
                even1 += nums[i];
            }
        }
        return res;
    }

}
