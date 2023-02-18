package leetcode.leetcode202302;

import leetcode.CustomFunction;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            int l = 1, r = 1000;
            while (l <= r) {
                int y = l + (r - l) / 2;
                int f = customfunction.f(x, y);
                if (f > z) {
                    r = y - 1;
                } else if (f < z) {
                    l = y + 1;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    result.add(list);
                    break;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> findSolution02(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(x);
                pair.add(y);
                res.add(pair);
            }
        }
        return res;
    }


}
