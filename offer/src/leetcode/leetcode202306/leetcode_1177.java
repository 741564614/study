package leetcode.leetcode202306;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1177 {

    public static void main(String[] args) {
        int[][] k=new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        System.out.println(new leetcode_1177().canMakePaliQueries("abcda",k));
    }
    
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] cnt = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            cnt[index][i + 1] = cnt[index][i] + 1;
            for (int j = 0; j < 26; j++) {
                if (index != j) {
                    cnt[j][i + 1] = cnt[j][i];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(check(cnt, queries[i]));
        }
        return ans;
    }

    public boolean check(int[][] cnt, int[] query) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if ((cnt[i][query[1]+1] - cnt[i][query[0]]) % 2 != 0) {
                count++;
            }
        }
        return (count / 2) <= query[2];
    }

    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int n = s.length();
            int[] count = new int[n + 1];
            for (int i = 0; i < n; i++) {
                count[i + 1] = count[i] ^ (1 << (s.charAt(i) - 'a'));
            }
            List<Boolean> res = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0], r = queries[i][1], k = queries[i][2];
                int bits = 0, x = count[r + 1] ^ count[l];
                while (x > 0) {
                    x &= x - 1;
                    bits++;
                }
                res.add(bits <= k * 2 + 1);
            }
            return res;
        }
    }
}
