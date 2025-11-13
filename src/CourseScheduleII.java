import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            int k = pre[1];
            int node = pre[0];
            List<Integer> list = map.getOrDefault(k, new ArrayList<>());
            list.add(node);
            map.put(k, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            res.add(node);
            if (!map.containsKey(node)) {
                continue;
            }
            List<Integer> list = map.get(node);
            list.forEach(i -> {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.addLast(i);
                }
            });

        }

        if (res.size() == numCourses) {
            return res.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
    }

}
