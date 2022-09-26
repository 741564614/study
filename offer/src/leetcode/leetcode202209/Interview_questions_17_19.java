package leetcode.leetcode202209;

public class Interview_questions_17_19 {
    public static void main(String[] args) {

    }

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (n + 1) / 2;
        for (int num : nums) {
            cur -= num;
        }
        int sum = cur, t = cur / 2;
        cur = t * (t + 1) / 2;
        for (int num : nums) {
            if (num <= t) {
                cur -= num;
            }
        }
        return new int[]{cur, sum - cur};
    }
}
