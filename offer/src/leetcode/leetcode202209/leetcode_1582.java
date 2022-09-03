package leetcode.leetcode202209;

public class leetcode_1582 {
    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        boolean[][] check = new boolean[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!check[i][j] && mat[i][j] == 1 && find(mat, check, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int numSpecialOrigin(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] colCheck = new int[col];
        int[] rowCheck = new int[row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                colCheck[i] += mat[j][i];
                rowCheck[j] += mat[j][i];
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && rowCheck[i] == 1 && colCheck[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean find(int[][] mat, boolean[][] check, int i, int j) {
        boolean result = true;
        for (int k = 0; k < mat[0].length; k++) {
            check[i][k] = true;
            if (k != j && mat[i][k] == 1) {
                result = false;
            }
        }
        for (int k = 0; k < mat.length; k++) {
            check[k][j] = true;
            if (k != i && mat[k][j] == 1) {
                result = false;
            }
        }
        return result;
    }
}
