import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class SimplifyPath {


    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] strs = path.split("/");

        for (String s : strs) {
            if (s.isBlank()) {
                continue;
            } else if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if(stack.isEmpty()){
                    continue;
                }else {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        return "/" + String.join("/", stack.reversed());

    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }
}
