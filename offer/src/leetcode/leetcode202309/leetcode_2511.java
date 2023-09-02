package leetcode.leetcode202309;

public class leetcode_2511 {
    public int captureForts(int[] forts) {
        int ans = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                int l = i - 1, r = i + 1;
                while (l >= 0 && forts[l] == 0) {
                    l--;
                }
                while (r < forts.length && forts[r] == 0) {
                    r++;
                }
                ans = Math.max(ans, Math.max(l >= 0 && forts[l] == -1 ? i - l - 1 : 0, r < forts.length && forts[r] == -1 ? r - i - 1 : 0));
            }
        }
        return ans;
    }

    class Solution {
        public int captureForts(int[] forts) {
            int n = forts.length;
            int ans = 0, pre = -1;
            for (int i = 0; i < n; i++) {
                if (forts[i] == 1 || forts[i] == -1) {
                    if (pre >= 0 && forts[i] != forts[pre]) {
                        ans = Math.max(ans, i - pre - 1);
                    }
                    pre = i;
                }
            }
            return ans;
        }
    }

}
