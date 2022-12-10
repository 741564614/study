package leetcode.leetcode202212;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_1691 {
    public static void main(String[] args) {
        int[][] k = new int[][]{{29, 59, 36}, {12, 13, 97}, {49, 86, 43}, {9, 57, 50}, {97, 19, 10}, {17, 92, 69}, {92, 36, 15}, {16, 63, 8}, {94, 24, 78}, {52, 11, 39}, {48, 61, 57}, {15, 44, 79}, {6, 69, 98}, {30, 70, 41}, {23, 17, 33}, {85, 86, 12}, {13, 75, 98}, {75, 30, 30}, {89, 18, 27}, {94, 83, 81}};
        System.out.println(new leetcode_1691().maxHeight02(k));
    }

    public int maxHeight02(int[][] cuboids) {
        int max = 0;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, Comparator.comparingInt(a -> a[0] * a[1] * a[2]));
        int[] f = new int[cuboids.length + 10];
        for (int i = 0; i < cuboids.length; i++) {
            f[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1]&&cuboids[j][2]<=cuboids[i][2]) {
                    f[i] = Math.max(f[i], f[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, f[i]);
        }

        return max;
    }

}
