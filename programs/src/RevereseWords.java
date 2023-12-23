public class RevereseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello  world  "));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
