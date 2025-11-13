import java.util.Arrays;

public class CheapestFlights {

    public static void main(String[] args) {
        CheapestFlights instance = new CheapestFlights();
        //int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600}};
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(instance.findCheapestPrice(4, flights, 0, 3, 1));
    }

    //bellman_ford 对所有边最多松弛K次得到的最短值
    //在 Bellman-Ford 处理步数限制的变体中，必须使用两个数组（或一个数组和它的副本）来隔离上一步的结果和当前步的更新
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minPrice = new int[n];//原点到i的最小花费

        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(minPrice, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int t = flight[1];
                int price = flight[2];

                if (temp[s]!=Integer.MAX_VALUE && price + temp[s] < minPrice[t]) {
                    minPrice[t] = price + temp[s];
                }
            }
        }

        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }


}
