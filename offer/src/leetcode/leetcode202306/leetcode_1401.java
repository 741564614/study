package leetcode.leetcode202306;

public class leetcode_1401 {

    public static void main(String[] args) {
        System.out.println(new leetcode_1401().checkOverlap(4, 9, 3, 1, 5, 2, 10));
    }

    int x1, x2, y1, y2;

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        boolean isUpDown = yCenter > y2 || yCenter < y1;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        return checkTop(xCenter, yCenter, radius, x1, y1, isUpDown) ||
                checkTop(xCenter, yCenter, radius, x1, y2, isUpDown) ||
                checkTop(xCenter, yCenter, radius, x2, y1, isUpDown) ||
                checkTop(xCenter, yCenter, radius, x2, y2, isUpDown) ||
                (!isUpDown && xCenter <= x2 && xCenter >= x1);
    }

    public boolean checkTop(int xc, int yc, int r, int x, int y, boolean isUpDown) {
        int a = Math.abs(xc - x), b = Math.abs(yc - y);
        int c2 = a * a + b * b;
        return (isUpDown ? b <= r && xc <= x2 && xc >= x1 : a <= r && yc <= y2 && yc >= y1) || c2 <= r * r;
    }

    class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            double dist = 0;
            if (xCenter < x1 || xCenter > x2) {
                dist += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(x2 - xCenter, 2));
            }
            if (yCenter < y1 || yCenter > y2) {
                dist += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(y2 - yCenter, 2));
            }
            return dist <= radius * radius;
        }
    }

}
