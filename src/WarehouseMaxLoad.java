import java.util.*;

public class WarehouseMaxLoad {

    public static int[] findMaxLoadPeriod(int[][] loads) {
        if (loads == null || loads.length == 0) {
            return new int[]{0, 0};
        }

        // 使用TreeMap来自动排序时间点并记录变化量
        TreeMap<Integer, Integer> timePoints = new TreeMap<>();

        // 记录每个时间点的货物变化
        for (int[] load : loads) {
            int start = load[0];
            int end = load[1];
            int amount = load[2];

            // 存入时刻货物增加
            timePoints.put(start, timePoints.getOrDefault(start, 0) + amount);
            // 取出时刻货物减少
            timePoints.put(end, timePoints.getOrDefault(end, 0) - amount);
        }

        int maxLoad = 0;
        int currentLoad = 0;
        int startTime = -1;
        int endTime = -1;
        int candidateStart = -1;

        // 扫描所有时间点
        for (Map.Entry<Integer, Integer> entry : timePoints.entrySet()) {
            int time = entry.getKey();
            int change = entry.getValue();

            int previousLoad = currentLoad;
            currentLoad += change;

            if (currentLoad > maxLoad) {
                // 发现新的最大值
                maxLoad = currentLoad;
                candidateStart = time;
                startTime = time;
                endTime = time;
            } else if (currentLoad == maxLoad && previousLoad < maxLoad) {
                // 开始达到最大值
                candidateStart = time;
            } else if (currentLoad < maxLoad && previousLoad == maxLoad) {
                // 结束最大值
                if (candidateStart != -1) {
                    startTime = candidateStart;
                    endTime = time;
                    candidateStart = -1;
                }
            }
        }

        // 处理最大值持续到最后的情况
        if (candidateStart != -1) {
            startTime = candidateStart;
            // 如果没有明确的结束时间，可以设置为最后一个时间点或一个很大的数
            endTime = timePoints.lastKey();
        }

        return new int[]{startTime, endTime};
    }


    public static void main(String[] args) {
        // 测试用例
        int[][] loads1 = {
                {1, 5, 10},
                {2, 4, 5},
                {3, 6, 8}
        };

        int[][] loads2 = {
                {1, 3, 5},
                {2, 4, 10},
                {3, 5, 5}
        };

        int[][] loads3 = {
                {1, 10, 20},
                {5, 8, 15}
        };

        System.out.println("测试用例1: " + Arrays.toString(findMaxLoadPeriod(loads1)));
        System.out.println("测试用例2: " + Arrays.toString(findMaxLoadPeriod(loads2)));
        System.out.println("测试用例3: " + Arrays.toString(findMaxLoadPeriod(loads3)));
    }
}