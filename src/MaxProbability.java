import java.util.*;

public class MaxProbability {

    public static void main(String[] args) {
        MaxProbability instance = new MaxProbability();
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] suucProb = {0.5, 0.2, 0.5};
        System.out.println(instance.maxProbability1(3, edges, suucProb, 1, 2));
    }

    //1. 找到距离原点概率最大的，未访问过的节点
    //2. 将节点标记为访问过
    //3. 更新所有未访问过的节点到原点的概率
    //4. 遍历每一个节点，遍历结束后输出最后一个节点到原点的最大概率
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        boolean[] visited = new boolean[n];
        double[][] grid = new double[n][n];

        //邻接矩阵保存图
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int t = edges[i][1];
            double val = succProb[i];
            grid[s][t] = val;
            grid[t][s] = val;
        }


        maxProb[start_node] = 1.0;//初始化

        for (int i = 0; i < n; i++) {
            double max = 0.0;
            int cur = -1;

            for (int j = 0; j < n; j++) {//1
                if (!visited[j] && maxProb[j] > max) {
                    max = maxProb[j];
                    cur = j;
                }
            }

            if (cur == -1) {
                break;
            }

            visited[cur] = true;//2


            for (int j = 0; j < n; j++) {//3
                if (!visited[j] && grid[cur][j] > 0 && grid[cur][j] * maxProb[cur] > maxProb[j]) {
                    maxProb[j] = grid[cur][j] * maxProb[cur];
                }
            }
        }

        return maxProb[end_node];
    }

    private static class Edge {
        int to;
        double val;

        Edge(int to, double val) {
            this.to = to;
            this.val = val;
        }
    }

    /** 堆排序优化 */
    //1. 找到距离原点概率最大的，未访问过的节点
    //2. 将节点标记为访问过
    //3. 更新所有未访问过的节点到原点的概率
    //4. 遍历每一个节点，遍历结束后输出最后一个节点到原点的最大概率
    public double maxProbability1(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];//保存当前点i到起点的最大概率
        boolean[] visited = new boolean[n];
        Map<Integer, List<Edge>> map = new HashMap<>();
        // 优先队列中存放 pair<节点编号，源点到该节点的权值>，存距离原点概率最大的，未访问过的节点 ，未加入到路径的节点
        Queue<Edge> queue = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));


        //邻接表保存图
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int t = edges[i][1];
            double val = succProb[i];
            // 边 u -> v
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(new Edge(t, val));
            // 边 v -> u (无向图)
            map.computeIfAbsent(t, k -> new ArrayList<>()).add(new Edge(s, val));
        }

        maxProb[start_node] = 1.0;//初始化
        queue.add(new Edge(start_node, 1.0));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int curNode = cur.to;
            double currentProb = cur.val;
            visited[curNode] = true;

            // 2. **修复：防止处理旧的、较差的路径**
            // 如果当前取出的概率小于 maxProb 中记录的已知最大概率，则跳过（这个是旧数据）
//            if (currentProb < maxProb[curNode]) {
//                continue;
//            }

            // 优化：如果已经到达终点，可以直接返回结果
            if (curNode == end_node) {
                return currentProb;
            }

            // 遍历邻居
            List<Edge> list = map.getOrDefault(curNode, Collections.emptyList());
            for (Edge edge : list) {
                if (!visited[edge.to] && edge.val * cur.val > maxProb[edge.to]) {
                    maxProb[edge.to] = edge.val * cur.val;
                    queue.add(new Edge(edge.to, maxProb[edge.to]));//只放未访问过的
                }
            }
        }
        return maxProb[end_node];
    }


}
