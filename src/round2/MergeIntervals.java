package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int xstart = intervals[i][0];
            int xend = intervals[i][1];
            if (xstart <= end) {
                end = Math.max(end, xend);
            } else {
                list.add(new int[]{start, end});
                start = xstart;
                end = xend;

            }
        }

        list.add(new int[]{start, end});//最后一个区间

        return list.toArray(int[][]::new);
    }
}
