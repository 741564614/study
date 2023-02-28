package leetcode.leetcode202302;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2363 {

    public static void main(String[] args) {
        int[][] items1 = new int[][]{{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = new int[][]{{3, 1}, {1, 5}};
        System.out.println(new leetcode_2363().mergeSimilarItems(items1, items2));
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] values = new int[1001];
        for (int[] ints : items1) {
            values[ints[0]] += ints[1];
        }
        for (int[] ints : items2) {
            values[ints[0]] += ints[1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                ans.add(List.of(i, values[i]));
            }
        }
        return ans;
    }
}
