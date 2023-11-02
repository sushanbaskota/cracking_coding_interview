public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}
