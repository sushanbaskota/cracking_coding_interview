public class IsPalindrome {
    public static void main(String[] args) {
        //  System.out.println(isPalindrome("susus"));
        System.out.println(isPalindrome("abca"));
    }

    private static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }

        return word.charAt(0) == word.charAt(word.length() - 1) &&
                isPalindrome(word.substring(1, word.length() - 1));
    }
}
