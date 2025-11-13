public class FindPath {

    int[] path;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        init(n);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return pathExist(source, destination);
    }

    private void init(int n) {
        path = new int[n];

        for (int i = 0; i < n; i++) {
            path[i] = i;
        }
    }

    private void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);
        if (a == b) {
            return;
        }
        path[a] = b;
    }

    private boolean pathExist(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);
        return a == b;
    }

    private int findRoot(int a) {
        if (a == path[a]) {
            return path[a];
        }
        path[a] = findRoot(path[a]);
        return path[a];
    }
}
