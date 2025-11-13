import java.util.*;

public class NetworkDelay {

    public static void main(String[] args) {
        NetworkDelay instance = new NetworkDelay();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(instance.networkDelayTime1(times, 4, 2));
    }


    //找到不在路径上的，但距离原点delay最小的点
    //加入路径
    //更新所有其他不在路径上的点到原点的minDelay
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n + 1];
        int[] minDelay = new int[n + 1];
        Map<Integer, List<Edge>> map = new HashMap<>();
        //未访问过的点到原点的delay 组成的边
        Queue<Edge> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        //把图存到邻接表
        for (int[] time : times) {
            int s = time[0];
            int t = time[1];
            int val = time[2];
            map.computeIfAbsent(s, it -> new ArrayList<>()).add(new Edge(t, val));
        }

        //初始化minDelay
        Arrays.fill(minDelay, Integer.MAX_VALUE);
        minDelay[k] = 0;
        queue.add(new Edge(k, 0));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            visited[cur.to] = true;

            List<Edge> list = map.getOrDefault(cur.to, Collections.emptyList());
            for (Edge edge : list) {
                if (!visited[edge.to] && cur.val + edge.val < minDelay[edge.to]) {
                    minDelay[edge.to] = cur.val + edge.val;
                    queue.add(new Edge(edge.to, minDelay[edge.to]));
                }
            }
        }


        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (minDelay[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                res = Math.max(res, minDelay[i]);
            }
        }
        return res;
    }

    public int networkDelayTime1(int[][] times, int n, int k) {
        boolean[] inqueue = new boolean[n + 1];
        int[] minDelay = new int[n + 1];
        Map<Integer, List<Edge>> map = new HashMap<>();
        //未访问过的点到原点的delay 组成的边
        List<Edge> queue = new LinkedList<>();

        //把图存到邻接表
        for (int[] time : times) {
            int s = time[0];
            int t = time[1];
            int val = time[2];
            map.computeIfAbsent(s, it -> new ArrayList<>()).add(new Edge(t, val));
        }

        //初始化minDelay
        Arrays.fill(minDelay, Integer.MAX_VALUE);
        minDelay[k] = 0;
        queue.add(new Edge(k, 0));
        inqueue[k] = true;

        while (!queue.isEmpty()) {
            Edge cur = queue.removeFirst();
            inqueue[cur.to] = false;

            List<Edge> list = map.getOrDefault(cur.to, Collections.emptyList());
            for (Edge edge : list) {
                if (minDelay[cur.to] + edge.val < minDelay[edge.to]) {
                    minDelay[edge.to] = minDelay[cur.to] + edge.val;

                    if (!inqueue[edge.to]) {
                        queue.addLast(new Edge(edge.to, minDelay[edge.to]));
                        inqueue[edge.to] = true;
                    }
                }
            }
        }


        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (minDelay[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                res = Math.max(res, minDelay[i]);
            }
        }
        return res;
    }

    private static class Edge {
        int to;
        int val;

        Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
}
