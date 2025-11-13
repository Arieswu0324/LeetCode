import java.util.ArrayList;
import java.util.List;

public class Kruskal {

    private int[] tree;

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        int n = points.length;
        init(n);

        //收集边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge edge = new Edge(i + 1, j + 1, val);
                edges.add(edge);
            }
        }

        //按val 排序
        List<Edge> edgeList = edges.stream()
                .filter(e -> e.val != 0)
                .sorted((a, b) -> a.val - b.val)
                .toList();

        //把边加入生成树，如果已经在生成树，跳过，收集权值
        int res = 0;
        for (Edge e : edgeList) {
            if (isSame(e.s, e.t)) {
                continue;
            }
            union(e.s, e.t);
            res += e.val;
        }

        return res;
    }

    private void init(int n) {
        tree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = i;
        }
    }

    private void union(int s, int t) {
        s = findRoot(s);
        t = findRoot(t);
        if (s != t) {
            tree[s] = t;
        }

    }

    private boolean isSame(int s, int t) {
        s = findRoot(s);
        t = findRoot(t);
        return s == t;
    }

    private int findRoot(int a) {
        if (a == tree[a]) {
            return tree[a];
        }
        tree[a] = findRoot(tree[a]);
        return tree[a];
    }

    private static class Edge {
        int s;
        int t;
        int val;

        Edge(int s, int t, int val) {
            this.s = s;
            this.t = t;
            this.val = val;
        }
    }
}
