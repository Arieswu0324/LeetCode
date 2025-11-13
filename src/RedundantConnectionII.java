

//三种情况（拆环）
//1, 当某一个结点入度为2时，任意删掉入度为2的其中一条边，返回第二条边
//2， 当某一个结点入度为2时，需要指定删除其中一条边保证此时不存在环，删除指一条边
//3, 不存在入度为2的结点，需要删除的是环中的一条边

import java.util.ArrayList;
import java.util.List;

public class RedundantConnectionII {

    int[] path;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        init(edges.length);

        //填充每一个节点的入度
        int[] indegree = new int[edges.length+1];
        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }

        List<int[]> list = new ArrayList<>();
        //找到组成入度为2节点的2条边
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 2) {
                for (int[] edge : edges) {
                    if (edge[1] == i) {
                        list.add(edge);
                    }

                }
            }
        }

        if (list.size() == 2) {
            if (isTreeAfterDeletion(edges, list.get(1))) {
                return list.get(1); //情况1
            } else {
                return list.get(0); //情况2
            }

        }
        //情况3
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

    private boolean isTreeAfterDeletion(int[][] edges, int[] edge) {
        for(int[] e: edges){
            if(e==edge){
                continue;
            }

            if(existsSame(e[0], e[1])){
                return false;
            }

            union(e[0], e[1]);
        }
            return true;
    }

    private void init(int n) {
        path = new int[n + 1];

        for (int i = 0; i <= n; i++) {
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
