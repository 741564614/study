package leetcode.leetcode202309;

public class leetcode_2605 {

    public static void main(String[] args) {
        int[] k = new int[]{6, 4, 3, 7, 2, 1, 8, 5};
        int[] m = new int[]{6, 8, 5, 3, 1, 7, 4, 2};
        System.out.println(new leetcode_2605().minNumber(k, m));
    }

    public int minNumber(int[] nums1, int[] nums2) {
        int[] cnt = new int[10];
        int minN1 = Integer.MAX_VALUE, minN2 = Integer.MAX_VALUE;
        for (int i : nums1) {
            cnt[i]++;
            minN1 = Math.min(minN1, i);
        }
        for (int i : nums2) {
            cnt[i]++;
            minN2 = Math.min(minN2, i);
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 2) {
                return i;
            }
        }
        return Math.min(minN1, minN2) * 10 + Math.max(minN1, minN2);
    }
}
