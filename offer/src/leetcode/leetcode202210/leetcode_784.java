package leetcode.leetcode202210;

import java.util.ArrayList;
import java.util.List;

public class leetcode_784 {

    public static void main(String[] args) {
        System.out.println('a' + 0);
        System.out.println('A' + 0);
        String s="3z4";
        System.out.println(letterCasePermutation(s));
    }


    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        ans.add(s);
        char[] array = s.toCharArray();
        dfs(array, ans, 0);
        return ans;
    }

    public static void dfs(char[] array, List<String> ans, int index) {
        for (int i = index; i < array.length; i++) {
            if (array[i] >= 'a' && array[i] <= 'z') {
                array[i] -= 32;
                ans.add(new String(array));
                dfs(array, ans, i + 1);
                array[i] += 32;
            } else if (array[i] >= 'A' && array[i] <='Z') {
                array[i] += 32;
                ans.add(new String(array));
                dfs(array, ans, i + 1);
                array[i] -= 32;
            }
        }
    }
}
