public class IndexOfFirstOccurence {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (haystackLength < needleLength) {
            return -1;
        }

        for (int i = 0; i < haystackLength; i++) {
            if ((i + needleLength) <= haystackLength) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    String newString = haystack.substring(i, i + needleLength);

                    if (newString.equals(needle)) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}
