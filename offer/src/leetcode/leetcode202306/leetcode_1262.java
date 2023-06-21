package leetcode.leetcode202306;

import java.util.Arrays;
import java.util.*;

public class leetcode_1262 {

    public static void main(String[] args) {
        int[] k = new int[]{4};
        System.out.println(new leetcode_1262().maxSumDivThree(k));
    }

    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int ans = Arrays.stream(nums).sum();
        int cut = ans % 3;
        if (cut == 1) {
            boolean two = false;
            int oneC = 0, twoC = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 3 == 2 && !two) {
                    if (twoC != 0) {
                        two = true;
                    }
                    twoC += nums[i];
                }
                if (nums[i] % 3 == 1 && oneC == 0) {
                    oneC = nums[i];
                }
                if (two && oneC != 0) {
                    break;
                }
            }
            ans -= two && oneC != 0 ? Math.min(oneC, twoC) : two ? twoC : oneC;
        } else if (cut == 2) {
            boolean one = false;
            int oneC = 0, twoC = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 3 == 1 && !one) {
                    if (oneC != 0) {
                        one = true;
                    }
                    oneC += nums[i];
                }
                if (nums[i] % 3 == 2 && twoC == 0) {
                    twoC = nums[i];
                }
                if (one && twoC != 0) {
                    break;
                }
            }
            ans -= one && twoC != 0 ? Math.min(oneC, twoC) : one ? oneC : twoC;
        }
        return ans;
    }

    class Solution {
        public int maxSumDivThree(int[] nums) {
            // 使用 v[0], v[1], v[2] 分别表示 a, b, c
            List<Integer>[] v = new List[3];
            for (int i = 0; i < 3; ++i) {
                v[i] = new ArrayList<Integer>();
            }
            for (int num : nums) {
                v[num % 3].add(num);
            }
            Collections.sort(v[1], (a, b) -> b - a);
            Collections.sort(v[2], (a, b) -> b - a);

            int tot = Arrays.stream(nums).sum();
            int remove = Integer.MAX_VALUE;

            if (tot % 3 == 0) {
                remove = 0;
            } else if (tot % 3 == 1) {
                if (v[1].size() >= 1) {
                    remove = Math.min(remove, v[1].get(v[1].size() - 1));
                }
                if (v[2].size() >= 2) {
                    remove = Math.min(remove, v[2].get(v[2].size() - 2) + v[2].get(v[2].size() - 1));
                }
            } else {
                if (v[1].size() >= 2) {
                    remove = Math.min(remove, v[1].get(v[1].size() - 2) + v[1].get(v[1].size() - 1));
                }
                if (v[2].size() >= 1) {
                    remove = Math.min(remove, v[2].get(v[2].size() - 1));
                }
            }

            return tot - remove;
        }
    }
}
