package round2;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloon {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int count = 0;

        //保存交叉区间,当下一个气球不在交叉区间的时候，增加箭
        int start = points[0][0];
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int xstart = points[i][0];
            int xend = points[i][1];
            if (xstart <= end) {
                start = Math.max(xstart, start);
                end = Math.min(xend, end);
            } else {
                count++;
                start = xstart;
                end = xend;
            }


        }

        //最后一个气球
        return count+1;
    }
}
