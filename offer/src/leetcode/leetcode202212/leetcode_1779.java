package leetcode.leetcode202212;

public class leetcode_1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int a = points[i][0];
            int b = points[i][1];
            if (a == x || b == y) {
                int distance = Math.abs(a - x) + Math.abs(b - y);
                if (distance < min) {
                    min = distance;
                    index = i;
                }
            }
        }
        return index;
    }
}
