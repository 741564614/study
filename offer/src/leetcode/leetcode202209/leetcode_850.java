package leetcode.leetcode202209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode_850 {
    public static void main(String[] args) {

    }

    public int rectangleArea02(int[][] rectangles) {
        int mod = (int) 1e9 + 7;
        List<Integer> xList = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            xList.add(rectangle[0]);
            xList.add(rectangle[2]);
        }
        Collections.sort(xList);
        long ans = 0;
        for (int i = 1; i < xList.size(); i++) {
            int a = xList.get(i - 1), b = xList.get(i);
            int len = b - a;
            if (len == 0) {
                continue;
            }
            List<int[]> yList = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                if (rectangle[0] <= a && rectangle[2] >= b) {
                    yList.add(new int[]{rectangle[1], rectangle[3]});
                }
            }
            Collections.sort(yList, (y1, y2) -> y1[0] != y2[0] ? y1[0] - y2[0] : y1[1] - y2[1]);
            long tol = 0, l = -1, r = -1;
            for (int[] y : yList) {
                if (y[0] > r) {
                    tol += r - l;
                    l = y[0];
                    r = y[1];
                } else if (y[1] > r) {
                    r = y[1];
                }
            }
            tol += r - l;
            ans += len * tol;
            ans %= mod;
        }
        return (int) ans;
    }
}
