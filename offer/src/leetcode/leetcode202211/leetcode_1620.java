package leetcode.leetcode202211;

public class leetcode_1620 {
    public static void main(String[] args) {
        int[][] t = new int[][]{{0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}};
        System.out.println(bestCoordinate(t, 1));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        int maxx = 0, maxy = 0, minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxQ = 0;
        int[] ans = new int[2];
        for (int[] tower : towers) {
            maxx = Math.max(tower[0] + radius, maxx);
            maxy = Math.max(tower[1] + radius, maxy);
            minx = Math.min(tower[0] - radius, minx);
            miny = Math.min(tower[1] - radius, miny);
        }

        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <= maxy; j++) {
                int temp = 0;
                for (int[] tower : towers) {
                    double ra = getRadius(tower[0], tower[1], i, j);
                    if (ra <= radius) {
                        temp += Math.floor((tower[2] / (1 + ra)));
                    }
                }
                if (temp > maxQ) {
                    maxQ = temp;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    public static double getRadius(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public int[] bestCoordinate02(int[][] t, int radius) {
        int[] ans = new int[2];
        int max = 0;
        int radius2 = radius * radius;
        int ax = Integer.MAX_VALUE, ay = Integer.MAX_VALUE, bx = 0, by = 0;
        for (int[] tt : t) {
            ax = Math.min(tt[0], ax);
            bx = Math.max(tt[0], bx);
            ay = Math.min(tt[1], ay);
            by = Math.max(tt[1], by);

        }
        for (int i = ax; i <= bx; i++) {
            for (int j = ay; j <= by; j++) {
                int res = 0;
                for (int[] tt : t) {
                    int distance2 = (tt[0] - i) * (tt[0] - i) + (tt[1] - j) * (tt[1] - j);
                    if (distance2 <= radius2) {
                        res += tt[2] / (1 + Math.sqrt(distance2));
                    }
                }
                if (res > max) {
                    max = res;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
