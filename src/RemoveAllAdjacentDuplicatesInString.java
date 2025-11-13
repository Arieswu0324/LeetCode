import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s){
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
            return null;
        }else {
            return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
    }
}
