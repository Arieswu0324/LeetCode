package round2;

import java.util.*;

public class ReconstructItineraryDFS {
    Map<String, PriorityQueue<String>> map;
    List<String> path;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        path = new ArrayList<>();

        for (List<String> it : tickets) {
            String from = it.getFirst();
            String to = it.getLast();
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        dfs("JFK");

        return path.reversed();
    }

    private void dfs(String from) {
        PriorityQueue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty()) {
            String next = tos.poll();
            dfs(next);
        }

        path.add(from);

    }
}
