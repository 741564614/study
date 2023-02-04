package leetcode.leetcode202302;

import java.util.*;
import java.util.List;

public class leetcode_1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redPoints = new ArrayList[n];
        List<Integer>[] bluePoints = new ArrayList[n];

        for (int[] redEdge : redEdges) {
            if (redPoints[redEdge[0]] == null) {
                redPoints[redEdge[0]] = new ArrayList<>();
            }
            redPoints[redEdge[0]].add(redEdge[1]);
        }

        for (int[] blueEdge : blueEdges) {
            if (bluePoints[blueEdge[0]] == null) {
                bluePoints[blueEdge[0]] = new ArrayList<>();
            }
            bluePoints[blueEdge[0]].add(blueEdge[1]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][][] visited1 = new boolean[n][n][2];
        boolean[][][] visited2 = new boolean[n][n][2];

        ans[0]=0;
        traverse(ans, redPoints, bluePoints, visited1, true);
        traverse(ans, redPoints, bluePoints, visited2, false);

        return ans;
    }

    public void traverse(int[] ans, List<Integer>[] redPoints, List<Integer>[] bluePoints, boolean[][][] visited, boolean isRed) {
        List<Integer> neighPoint0 = isRed ? redPoints[0] : bluePoints[0];
        if (null != neighPoint0) {
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(neighPoint0);
            int len = 1;
            isRed=!isRed;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer next = queue.poll();
                    if (ans[next] == -1 || ans[next] > len) {
                        ans[next] = len;
                    }
                    List<Integer> neighPoint = isRed ? redPoints[next] : bluePoints[next];
                    if(null!=neighPoint){
                        for (Integer neigh : neighPoint) {
                            if(visited[next][neigh][isRed?0:1]){
                                continue;
                            }
                            visited[next][neigh][isRed?0:1]=true;
                            queue.offer(neigh);
                        }
                    }

                }
                len++;
                isRed=!isRed;
            }
        }
    }

    public int[] shortestAlternatingPaths02(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<Integer>();
            }
        }
        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        int[][] dist = new int[2][n]; // 两种类型的颜色最短路径的长度
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0], t = pair[1];
            for (int y : next[1 - t][x]) {
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1 - t});
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
