package leetcode.leetcode202306;

import java.util.*;

public class leetcode_2699 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1,-1},{1,2,-1},{3,1,-1},{3,0,2},{0,2,5}};
//        System.out.println(Arrays.deepToString(new leetcode_2699().modifiedGraphEdges(4, edges, 2, 3, 8)));
    }

    class Solution {
        long[] fromDestination;
        int target;

        public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
            this.target = target;
            int[][] adjMatrix = new int[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(adjMatrix[i], -1);
            }
            // 邻接矩阵中存储边的下标
            for (int i = 0; i < edges.length; ++i) {
                int u = edges[i][0], v = edges[i][1];
                adjMatrix[u][v] = adjMatrix[v][u] = i;
            }
            fromDestination = dijkstra(0, destination, edges, adjMatrix);
            if (fromDestination[source] > target) {
                return new int[0][];
            }
            long[] fromSource = dijkstra(1, source, edges, adjMatrix);
            if (fromSource[destination] != target) {
                return new int[0][];
            }
            return edges;
        }

        public long[] dijkstra(int op, int source, int[][] edges, int[][] adjMatrix) {
            // 朴素的 dijkstra 算法
            // adjMatrix 是一个邻接矩阵
            int n = adjMatrix.length;
            long[] dist = new long[n];
            Arrays.fill(dist, Integer.MAX_VALUE / 2);
            boolean[] used = new boolean[n];
            dist[source] = 0;

            for (int round = 0; round < n - 1; ++round) {
                int u = -1;
                for (int i = 0; i < n; ++i) {
                    if (!used[i] && (u == -1 || dist[i] < dist[u])) {
                        u = i;
                    }
                }
                used[u] = true;
                for (int v = 0; v < n; ++v) {
                    if (!used[v] && adjMatrix[u][v] != -1) {
                        if (edges[adjMatrix[u][v]][2] != -1) {
                            dist[v] = Math.min(dist[v], dist[u] + edges[adjMatrix[u][v]][2]);
                        } else {
                            if (op == 0) {
                                dist[v] = Math.min(dist[v], dist[u] + 1);
                            } else {
                                int modify = (int) (target - dist[u] - fromDestination[v]);
                                if (modify > 0) {
                                    dist[v] = Math.min(dist[v], dist[u] + modify);
                                    edges[adjMatrix[u][v]][2] = modify;
                                } else {
                                    edges[adjMatrix[u][v]][2] = target;
                                }
                            }
                        }
                    }
                }
            }

            return dist;
        }
    }


//    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
//        int[][] matrix = new int[n][n];
//        for (int[] edge : edges) {
//            matrix[edge[0]][edge[1]] = edge[2];
//            matrix[edge[1]][edge[0]] = edge[2];
//        }
//        Queue<MapNode> queue = new LinkedList<>();
//        queue.offer(new MapNode(n, source));
////        MapNode change = null;
//        List<MapNode> path=new ArrayList<>();
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                MapNode poll = queue.poll();
//                if (poll.cur == destination) {
//                    if (poll.sum == target && poll.cnt == 0) {
//                        return edges;
//                    }
//                    path.add(poll);
////                    if (target - poll.sum >= poll.cnt && poll.cnt > 0) {
////                        change = poll;
////                        break;
////                    }
//                } else {
//                    for (int j = 0; j < matrix[poll.cur].length; j++) {
//                        if (!poll.check[j] && matrix[poll.cur][j] != 0) {
//                            queue.offer(poll.next(j, matrix[poll.cur][j]));
//                        }
//                    }
//                }
//            }
//        }
//        if (path.isEmpty()) {
//            return new int[0][0];
//        }
//        int sum = 0, each = (target - change.sum) / change.cnt, index = 1;
//        while (change.cnt > 0) {
//            Integer x = change.path.get(index - 1);
//            Integer y = change.path.get(index++);
//            if (matrix[x][y] == -1) {
//                matrix[x][y] = change.cnt == 1 ? (target - change.sum - sum) : each;
//                matrix[y][x] = change.cnt == 1 ? (target - change.sum - sum) : each;
//                sum += each;
//                change.cnt--;
//            }
//        }
//        for (int[] edge : edges) {
//            int x = edge[0];
//            int y = edge[1];
//            edge[2] = Math.max(matrix[x][y], 1);
//        }
//        return edges;
//    }
//
//    class MapNode {
//        boolean[] check;
//        LinkedList<Integer> path;
//        int cur;
//        int sum;
//        int cnt;
//
//        public MapNode() {
//        }
//
//        public MapNode(int n, int root) {
//            this.check = new boolean[n];
//            this.path = new LinkedList<>();
//            path.add(root);
//            this.cur = root;
//            this.sum = 0;
//            this.cnt = 0;
//        }
//
//        public MapNode next(int next, int weight) {
//            MapNode nextNode = clone(this);
//            nextNode.cur = next;
//            nextNode.sum += weight == -1 ? 0 : weight;
//            nextNode.cnt += weight == -1 ? 1 : 0;
//            nextNode.path.add(next);
//            nextNode.check[next] = true;
//            return nextNode;
//        }
//
//        public MapNode clone(MapNode node) {
//            MapNode next = new MapNode();
//            next.check = Arrays.copyOf(node.check, node.check.length);
//            next.cur = node.cur;
//            next.sum = node.sum;
//            next.cnt = node.cnt;
//            next.path = new LinkedList<>(node.path);
//            return next;
//        }
//    }
}
