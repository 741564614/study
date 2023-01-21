package leetcode.leetcode202301;

public class leetcode_1824 {
    public int minSideJumps(int[] obstacles) {
        int ans = 0, nowRun = 2;
        for (int i = 0; i < obstacles.length; i++) {
            if (i + 1 < obstacles.length && nowRun == obstacles[i + 1]) {
                if (obstacles[i] == 0) {
                    while (i + 1 < obstacles.length && (obstacles[i + 1] == 0 || nowRun == obstacles[i + 1])) {
                        i++;
                    }
                    if (i + 1 < obstacles.length) {
                        nowRun = (nowRun ^ obstacles[i + 1]);
                    }
                } else {
                    nowRun = (obstacles[i + 1] ^ obstacles[i]);
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] o = new int[]{0, 2, 2, 1, 0, 3, 0, 3, 0, 1, 0};
        System.out.println(new leetcode_1824().minSideJumps(o));
    }
}
