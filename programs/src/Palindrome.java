import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome1(String str) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return str.equalsIgnoreCase(sb.toString());
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }

    private static String recurse(String str) {
        if (str.length() <= 1) {
            return str;
        }

        return str.charAt(0) + "" + recurse(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("susan"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("ab"));
    }
}
