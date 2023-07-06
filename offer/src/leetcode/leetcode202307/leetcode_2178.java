package leetcode.leetcode202307;

import java.util.*;
import java.util.List;

public class leetcode_2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        LinkedList<Long> ans = new LinkedList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }
        if (finalSum == 2 || finalSum == 4) {
            ans.add(finalSum);
            return ans;
        }
        long cut = 2;
        while (finalSum > 0) {
            if (cut <= finalSum) {
                ans.add(cut);
                finalSum -= cut;
            } else {
                while (ans.contains(finalSum)) {
                    Long last = ans.removeLast();
                    finalSum += last;
                }
                ans.add(finalSum);
                finalSum = 0;
            }
            cut += 2;
        }
        return ans;
    }

    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> res = new ArrayList<>();
            if (finalSum % 2 > 0) {
                return res;
            }
            for (long i = 2; i <= finalSum; i += 2) {
                res.add(i);
                finalSum -= i;
            }
            res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
            return res;
        }
    }

}
