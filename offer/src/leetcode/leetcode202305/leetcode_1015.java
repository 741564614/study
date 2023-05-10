package leetcode.leetcode202305;

import java.util.HashSet;
import java.util.Set;

public class leetcode_1015 {
    public int smallestRepunitDivByK02(int k) {
        int mod = 1 % k, ans = 1;
        Set<Integer> set = new HashSet<>();
        while (mod != 0) {
            if (!set.add(mod)) {
                return -1;
            }
            mod = (mod * 10 + 1) % k;
            ans++;
        }
        return ans;
    }

    class Solution {
        public int smallestRepunitDivByK(int k) {
            // 若 k 能被 2 或 5 整除，则无解，返回 -1
            if (k % 2 == 0 || k % 5 == 0) {
                return -1;
            }
            // 初始化余数为 1，表示一个数的最低位是 1
            int resid = 1 % k, len = 1;
            // 若余数不为 0，继续迭代
            while (resid != 0) {
                // 计算下一个数的余数，下一个数在当前余数后加一个 1
                resid = (resid * 10 + 1) % k;
                len++;
            }
            // 返回数字 1 的最小重复次数
            return len;
        }
    }

}
