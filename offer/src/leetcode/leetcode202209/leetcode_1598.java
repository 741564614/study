package leetcode.leetcode202209;

public class leetcode_1598 {
    public static void main(String[] args) {
        String[] logs = new String[]{"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (log.equals("../") && ans > 0) {
                ans--;
            } else if (!log.equals("./") && !log.equals("../")) {
                ans++;
            }
        }
        return Math.max(ans, 0);
    }
}
