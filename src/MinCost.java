import java.util.Arrays;

public class MinCost {

    public static void main(String[] args) {
        MinCost instance = new MinCost();
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(instance.minCostConnectPoints(points));
    }

    //非生成树距离生成树最近的节点
    //加入生成树
    //更新所有非生成树结点到生成树的最小距离
    //遍历直到所有节点加入生成树
    public int minCostConnectPoints(int[][] points) {
        //points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
        //n:          1     2     3      4     5

        //存点
        int n = points.length;
        //存边
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //|xi - xj| + |yi - yj|
                int val = Math.abs(points[i-1][0] - points[j-1][0]) + Math.abs(points[i-1][1] - points[j-1][1]);
                grid[i][j] = val;
            }
        }

        boolean[] isInTree = new boolean[n + 1];
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);



        for (int i = 1; i < n; i++) {//1
            int minValue = Integer.MAX_VALUE;
            int cur = 1;//初始化
            for (int j = 1; j <= n; j++) {
                if (!isInTree[j] && minDist[j] < minValue) {
                    minValue = minDist[j];
                    cur = j;
                }
            }//找到minDist中的最小值，和最小值对应的节点

            isInTree[cur] = true;//2

            for (int j = 1; j <= n; j++) {//3
                if (!isInTree[j] && grid[cur][j] < minDist[j]) {
                    minDist[j] = grid[cur][j];
                }
            }

        }

        return Arrays.stream(minDist).filter(i -> i != Integer.MAX_VALUE).sum();
    }


}
