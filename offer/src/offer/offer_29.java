package offer;

public class offer_29 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = new int[][]{{1}, {1}, {1}};
        System.out.println(new offer_29().spiralOrder(matrix));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length, i = 0, j = 0, step = 0;
        int[] ans = new int[m * n];
        boolean[][] visited = new boolean[m][n];
        int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int index = 0; index < m * n; index++) {
            ans[index] = matrix[i][j];
            visited[i][j] = true;
            int nextI = i + move[step][0], nextJ = j + move[step][1];
            if (nextI < 0 || nextI > m || nextJ < 0 || nextJ > n || visited[nextI][nextJ]) {
                step = (step + 1) % 4;
            }
            i += move[step][0];
            j += move[step][1];
        }
        return ans;
    }

    public int[] spiralOrder02(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
