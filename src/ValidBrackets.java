import java.util.Stack;

public class ValidBrackets {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i< ch.length; i++){
            if(stack.isEmpty()){
                stack.push(ch[i]);
            }else{
                char top = stack.peek();
                if(isLeft(top)&&getRight(top)==ch[i]){
                    stack.pop();
                }else{
                    stack.push(ch[i]);
                }
            }

        }
        return stack.isEmpty();
    }
    public static boolean isLeft(char c){
        return c=='(' || c=='{' || c== '[';
    }
    public static char getRight(char c){
        return switch (c) {
            case '(' -> ')';
            case '{' -> '}';
            case '[' -> ']';
            default -> c;
        };
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("([])"));
    }

}
