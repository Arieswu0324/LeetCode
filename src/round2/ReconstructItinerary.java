package round2;

import java.util.ArrayList;
import java.util.List;

public class ReconstructItinerary {
    //超时
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        boolean[] used = new boolean[tickets.size()];
        path.add("JFK");
        backtracking(tickets, used);
        return res;
    }

    private boolean backtracking(List<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            res =new ArrayList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && path.getLast().equals(tickets.get(i).getFirst())) {
                used[i] = true;
                path.add(tickets.get(i).get(1));
                if (
                        backtracking(tickets, used)) {
                    return true;
                }
                path.removeLast();
                used[i] = false;
            }
        }

        return false;
    }
}
