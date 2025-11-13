import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p1, p2)->{
            return Integer.compare(p1[0], p2[0]);
        });

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0]>intervals[i-1][1]){//不重叠
                int[] cur = {start, end};
                res.add(cur);
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(intervals[i][1], intervals[i-1][1]);
                intervals[i][1] = end;
            }
        }
        int[] cur = {start, end};
        res.add(cur);

        return res.stream().toArray(int[][]::new);

    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = instance.merge(intervals);
        Arrays.stream(merge).forEach(a-> System.out.println(Arrays.toString(a)));
    }
}
