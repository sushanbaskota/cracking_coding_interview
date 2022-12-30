import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        //System.out.println(new ValidParentheses().isValid("({]})"));
        //System.out.println(new ValidParentheses().isValid("){"));
        //System.out.println(new ValidParentheses().isValid(")(){}"));
        //System.out.println(new ValidParentheses().isValid("))"));
        System.out.println(new ValidParentheses().isValid("()))"));
        //System.out.println(new ValidParentheses().isValid("(){}[]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }
}
