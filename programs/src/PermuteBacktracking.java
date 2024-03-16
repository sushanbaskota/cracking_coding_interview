public class PermuteBacktracking {
    public static void main(String[] args) {
        permute("abc");
    }

    private static void permute(String word) {
        permuteHelper("", word);
    }

    private static void permuteHelper(String soFar, String rest) {
        if ("".equalsIgnoreCase(rest)) {
            System.out.println(soFar);
        } else {
            for (int i = 0; i < rest.length(); i++) {
                String remain = rest.substring(0, i) + rest.substring(i + 1);
                permuteHelper(soFar + rest.charAt(i), remain);
            }
        }
    }
}
