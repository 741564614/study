package leetcode.leetcode202209;

public class leetcode_1640 {
    public static void main(String[] args) {
        int[] a = new int[]{49, 18, 16};
        int[][] b = new int[][]{{16, 18, 49}};
        System.out.println(canFormArray(a, b));
    }

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            return search(0, arr, pieces);
        }

        public boolean search(int index, int[] arr, int[][] pieces) {
            for (int[] piece : pieces) {
                if (piece[0] == arr[index]) {
                    index++;
                    for (int i = 1 ;i < piece.length; i++) {
                        if (arr[index++] != piece[i]) return false;
                    }
                    if (index == arr.length) return true;
                    return search(index, arr, pieces);
                }
            }
            return false;
        }
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        boolean[] check = new boolean[pieces.length];
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            boolean used = false;
            for (int j = 0; j < pieces.length && index < arr.length; j++) {
                if (!check[j] && pieces[j][0] == arr[index]) {
                    for (int k = 0; k < pieces[j].length && index < arr.length; k++) {
                        if (pieces[j][k] != arr[index++]) {
                            return false;
                        }
                    }
                    check[j] = true;
                    i = index - 1;
                    used = true;
                    break;
                }
            }
            if (!used) {
                return false;
            }
        }
        return true;
    }
}
