
import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule instance = new CourseSchedule();
        int[][] pre = {{1, 0}};
        System.out.println(instance.canFinish(2, pre));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> sort = new ArrayList<>();


        //统计每个节点的入度, 统计每个节点的连接情况
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;

            int key = prerequisite[1];
            int node = prerequisite[0];
            List<Integer> nodes;
            if (map.containsKey(key)) {
                nodes = map.get(key);
            } else {
                nodes = new ArrayList<>();
            }
            nodes.add(node);
            map.put(key, nodes);
        }

        //入度为0加入队列
        for(int i = 0; i< numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.removeFirst();
            sort.add(node);

            if (!map.containsKey(node)) {
                continue;
            }
            List<Integer> nodes = map.get(node);

            nodes.forEach(i -> {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.addLast(i);
                }
            });

        }

        return sort.size() == numCourses;

    }


}
