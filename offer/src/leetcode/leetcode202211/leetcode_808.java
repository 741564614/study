package leetcode.leetcode202211;

import java.util.HashMap;
import java.util.Map;

public class leetcode_808 {
    public static void main(String[] args) {
        System.out.println(new leetcode_808().soupServings(10000));
    }


    double[][] map;

    public double soupServings(int n) {
        n = (int) Math.ceil(n / 25.0);
        if (n >= 179) {
            return 1.00000;
        }
        map = new double[n+1][n+1];
        return soupServings(n, n);
    }

    public double soupServings(int a, int b) {
        if (a > 0 && b <= 0) {
            return 0;
        }
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0 && b > 0) {
            return 1;
        }
        if(map[a][b]==0){
           map[a][b] = 0.25 * (soupServings(a - 4, b) + soupServings(a - 3, b - 1) + soupServings(a - 2, b - 2) + soupServings(a - 1, b - 3));
        }
        return map[a][b];
    }
}
