package leetcode.leetcode202304;

public class leetcode_1041 {
    public boolean isRobotBounded(String instructions) {
        int[] index = new int[2];
        //0北，1东，2南，3西
        int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0, curDirection = 0; i < instructions.length() * 4; i++) {
            char a = instructions.charAt(i % instructions.length());
            if (a == 'G') {
                index[0] += move[curDirection][0];
                index[1] += move[curDirection][1];
            } else if (a == 'L') {
                curDirection = (curDirection + 3) % 4;
            } else {
                curDirection = (curDirection + 1) % 4;
            }
        }
        return Math.abs(index[0]) + Math.abs(index[1]) == 0;
    }

    class Solution {
        public boolean isRobotBounded(String instructions) {
            int k = 0;
            int[] dist = new int[4];
            for (int i = 0; i < instructions.length(); ++i) {
                char c = instructions.charAt(i);
                if (c == 'L') {
                    k = (k + 1) % 4;
                } else if (c == 'R') {
                    k = (k + 3) % 4;
                } else {
                    ++dist[k];
                }
            }
            return (dist[0] == dist[2] && dist[1] == dist[3]) || (k != 0);
        }
    }
    
}
