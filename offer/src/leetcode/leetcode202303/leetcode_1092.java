package leetcode.leetcode202303;

public class leetcode_1092 {

    public static void main(String[] args) {
        String str1 = "bbbaaaba";
        String str2 = "bbababbb";
//        System.out.println(new leetcode_1092().shortestCommonSupersequence(str1, str2));
    }

    //    public String shortestCommonSupersequence(String str1, String str2) {
//        if (str1.length() == 0 && str2.length() == 0) {
//            return "";
//        } else if (str1.length() == 0) {
//            return str2;
//        } else if (str2.length() == 0) {
//            return str1;
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int length = str1.length(); length > 0; length--) {
//            for (int i = 0; i + length <= str1.length(); i++) {
//                String sub = str1.substring(i, i + length);
//                int index = str2.indexOf(sub);
//                if (index != -1) {
//                    String lSub1 = str1.substring(0, i);
//                    String rSub1 = str1.substring(i + length);
//                    String lSub2 = str2.substring(0, index);
//                    String rSub2 = str2.substring(index + length);
//                    stringBuilder.append(shortestCommonSupersequence(lSub1, lSub2));
//                    stringBuilder.append(sub);
//                    stringBuilder.append(shortestCommonSupersequence(rSub1, rSub2));
//                    return stringBuilder.toString();
//                }
//            }
//        }
//
//        return stringBuilder.toString();
//
//    }
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int m = str1.length(), n = str2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                }
            }
            int i = m, j = n;
            StringBuilder ans = new StringBuilder();
            while (i > 0 || j > 0) {
                if (i == 0) {
                    ans.append(str2.charAt(--j));
                } else if (j == 0) {
                    ans.append(str1.charAt(--i));
                } else {
                    if (f[i][j] == f[i - 1][j]) {
                        ans.append(str1.charAt(--i));
                    } else if (f[i][j] == f[i][j - 1]) {
                        ans.append(str2.charAt(--j));
                    } else {
                        ans.append(str1.charAt(--i));
                        --j;
                    }
                }
            }
            return ans.reverse().toString();
        }
    }

}
