import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if(isOperator(s)){
                Integer a = stack.pop();
                Integer b = stack.pop();
                Integer c = calculate(a,b,s);
                stack.push(c);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    private static Integer calculate(Integer a, Integer b, String op){
        return switch (op) {
            case "+" -> b + a;
            case "-" -> b - a;
            case "*" -> b * a;
            default -> b / a;
        };

    }

    public static void main(String[] args) {
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }
}
