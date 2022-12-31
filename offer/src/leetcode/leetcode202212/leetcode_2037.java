package leetcode.leetcode202212;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class leetcode_2037 {
    public static void main(String[] args) {
        int[] seats = new int[]{12, 14, 19, 19, 12};
        int[] students = new int[]{19, 2, 17, 20, 7};
        System.out.println(new leetcode_2037().minMovesToSeat(seats, students));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
