package leetcode.leetcode202303;

public class leetcode_1653 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1653().minimumDeletions("aaaaaabbbbabaaaabbabaaabbabbbaaabababaaaaaaabbaaabaaababaaabababa"));
    }

    public int minimumDeletions(String s) {
        int[] suffix = new int[s.length()];
        char[] chars = s.toCharArray();
        suffix[s.length() - 1] = chars[s.length() - 1] == 'b' ? 0 : 1;
        for (int i = chars.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + (chars[i] == 'b' ? 0 : 1);
        }
        int prefix = 0, min = suffix[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b') {
                prefix++;
            }
            int suffixNum = (chars[i] == 'a' ? Math.max(suffix[i] - 1, 0) : suffix[i]);
            min = Math.min(min, prefix + suffixNum);
        }
        return min;
    }

    public int minimumDeletions20(String s) {
        int dp = 0, countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else {
                dp = Math.min(dp + 1, countB);
            }
        }
        return dp;
    }
}
