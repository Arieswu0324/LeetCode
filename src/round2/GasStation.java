package round2;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        int index = -1;
        int sum = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            total+=diff[i];
            sum+=diff[i];
            if(sum<0){
                sum=0;
                index=i+1;
            }
        }

        if(total<0){
            return -1;
        }

        return index;
    }
}
