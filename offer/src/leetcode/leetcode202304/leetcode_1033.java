package leetcode.leetcode202304;

import java.util.Arrays;

public class leetcode_1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stone = new int[]{a, b, c};
        Arrays.sort(stone);
        int min = 2;
        min = Math.min(min, (stone[1] == stone[0] + 1 || stone[1] == stone[0] + 2 ? 1 : 0) + (stone[2] == stone[0] + 2 ? 1 : 0));
        min = Math.min(min, (stone[2] == stone[1] + 1 || stone[2] == stone[1] + 2 ? 1 : 0) + 1);
        return new int[]{min, stone[2] - stone[0] - 2};
    }

    public int[] numMovesStones20(int a, int b, int c) {
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (b > c) {
            c = b + c;
            b = c - b;
            c = c - b;
        }
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        int min = 2;
        min = Math.min(min, (b == a + 1 || b == a + 2 ? 0 : 1) + (c == a + 2 ? 0 : 1));
        min = Math.min(min, (c == b + 1 || c == b + 2 ? 0 : 1) + 1);
        return new int[]{min, c - a - 2};
    }
}
