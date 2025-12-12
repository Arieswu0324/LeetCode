package round2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AdjacentDuplicates {
    public static void main(String[] args) {
        AdjacentDuplicates instance = new AdjacentDuplicates();
        System.out.println(instance.removeDuplicates("abbaca"));
    }
    //"abbaca"
    public String removeDuplicates2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

       return stack.stream().toList().reversed().stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String removeDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            return "";
        }else {
            return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }
    }
}
