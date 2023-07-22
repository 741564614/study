package leetcode.leetcode202307;

public class leetcode_860 {
    public static void main(String[] args) {
        int[] k = new int[]{5, 5, 10, 10, 20};
        System.out.println(new leetcode_860().lemonadeChange(k));
    }

    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[4];
        for (int bill : bills) {
            cnt[(bill / 5) - 1]++;
            if (bill == 10) {
                if (cnt[0] == 0) {
                    return false;
                }
                cnt[0]--;
            } else if (bill == 20) {
                if ((cnt[0] < 3 && cnt[1] == 0) || (cnt[1] > 0 && cnt[0] == 0)) {
                    return false;
                }
                if (cnt[1] > 0) {
                    cnt[1]--;
                    cnt[0]--;
                } else {
                    cnt[0] -= 3;
                }
            }
        }
        return true;
    }
}
