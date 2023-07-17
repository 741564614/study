package leetcode.leetcode202307;

public class leetcode_415 {
    public String addStrings(String num1, String num2) {
        int k = 0, index1 = num1.length() - 1, index2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || k != 0) {
            int value = k;
            if (index1 >= 0 && index2 >= 0) {
                value += (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0');
            } else if (index1 < 0 && index2 >= 0) {
                value += (num2.charAt(index2) - '0');
            } else if (index1 >= 0) {
                value += (num1.charAt(index1) - '0');
            }
            k = value / 10;
            sb.append(value % 10);
            index1--;
            index2--;
        }
        return sb.reverse().toString();
    }

    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1, add = 0;
            StringBuffer ans = new StringBuffer();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            // 计算完以后的答案需要翻转过来
            ans.reverse();
            return ans.toString();
        }
    }

}
