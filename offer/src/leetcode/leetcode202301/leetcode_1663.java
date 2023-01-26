package leetcode.leetcode202301;

public class leetcode_1663 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1663().getSmallestString(4,100));
    }

    public String getSmallestString(int n, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int now = 0;
        while ((n - stringBuffer.length()) > 0 && (n - stringBuffer.length()) * 26 >= k - now) {
            stringBuffer.append('a');
            now++;
        }
        int len = (n - stringBuffer.length());
        if (len == 0 && (k - now) > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer.append((char) ('a' + (k - now)));
        } else if (len > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer.append((char) ('a' + ((k - now) - len * 26)));
            while (len-- > 0) {
                stringBuffer.append('z');
            }
        }
        return stringBuffer.toString();
    }


    public String getSmallestString02(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            ans.append((char) ('a' + lower - 1));
        }
        return ans.toString();
    }
}
