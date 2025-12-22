package round2;

import java.util.Arrays;

public class OverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int xstart = intervals[i][0];
            int xend = intervals[i][1];
            if (xstart < end) {
                count++;
                start = Math.max(start, xend);
                end = Math.min(end, xend);
            } else {
                start = xstart;
                end = xend;
            }
        }

        return count;
    }
}
