public class RedundantConnection {

    int[] path;

    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length);

        int[] res = null;
        for (int[] edge : edges) {
            if (existsSame(edge[0], edge[1])) {
                res = edge;
            } else {
                union(edge[0], edge[1]);
            }
        }
        return res;
    }

    private void init(int n) {
        path = new int[n+1];

        for (int i = 0; i <=n; i++) {
            path[i] = i;
        }
    }

    private void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);
        if (a != b) {
            path[a] = b;
        }
    }

    private int findRoot(int a) {
        if (path[a] == a) {
            return a;
        }
        path[a] = findRoot(path[a]);
        return path[a];
    }

    private boolean existsSame(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);
        return a == b;
    }
}
