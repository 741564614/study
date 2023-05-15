package leetcode.leetcode202305;

import java.util.*;

public class leetcode_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] check = new boolean[m][2];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                if (!check[i][j]) {
                    int temp = 1;
                    for (int k = 0; k < m; k++) {
                        if (k != i) {
                            int sum = 0;
                            for (int l = 0; l < n; l++) {
                                sum += matrix[i][l] == j ? matrix[k][l] : (matrix[k][l] + 1) % 2;
                            }
                            if (sum == 0 || sum == n) {
                                temp++;
                                check[k][sum == 0 ? 0 : 1] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < m; i++) {
                char[] arr = new char[n];
                Arrays.fill(arr, '0');
                for (int j = 0; j < n; j++) {
                    // 如果 matrix[i][0] 为 1，则对该行元素进行翻转
                    arr[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
                }
                String s = new String(arr);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            int res = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                res = Math.max(res, entry.getValue());
            }
            return res;
        }
    }

}
