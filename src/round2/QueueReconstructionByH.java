package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByH {

    //ArrayList.add(index, value) 当前index的值它会被“挤”到后一个位置（index + 1），而不会被覆盖或消失
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int d = o2[0] - o1[0];
                if (d == 0) {
                    return o1[1] - o2[1];
                }
                return d;
            }
        });

        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(int[][]::new);
    }


}
