package leetcode.leetcode202307;

import java.util.*;

public class leetcode_874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] move = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};//-2=+1%4,-1=+3%4
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            map.putIfAbsent(obstacle[0], new HashSet<>());
            map.get(obstacle[0]).add(obstacle[1]);
        }
        int x = 0, y = 0, m = 0, max = 0;
        for (int command : commands) {
            if (command == -2) {
                m = (m + 1) % 4;
            } else if (command == -1) {
                m = (m + 3) % 4;
            } else {
                while (command > 0) {
                    x += move[m][0];
                    y += move[m][1];
                    command--;
                    if (map.containsKey(x) && map.get(x).contains(y)) {
                        x -= move[m][0];
                        y -= move[m][1];
                        break;
                    }
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            int px = 0, py = 0, d = 1;
            Set<Integer> set = new HashSet<Integer>();
            for (int[] obstacle : obstacles) {
                set.add(obstacle[0] * 60001 + obstacle[1]);
            }
            int res = 0;
            for (int c : commands) {
                if (c < 0) {
                    d += c == -1 ? 1 : -1;
                    d %= 4;
                    if (d < 0) {
                        d += 4;
                    }
                } else {
                    for (int i = 0; i < c; i++) {
                        if (set.contains((px + dirs[d][0]) * 60001 + py + dirs[d][1])) {
                            break;
                        }
                        px += dirs[d][0];
                        py += dirs[d][1];
                        res = Math.max(res, px * px + py * py);
                    }
                }
            }
            return res;
        }
    }
}
