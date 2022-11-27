import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String firstStr = strs[0];
        int firstStrLength = firstStr.length();
        String[] prefixArr = new String[firstStrLength];

        //split the first str and create a array of prefixes
        for (int i = 0; i < firstStrLength; i++) {
            String prefix = firstStr.substring(0, i + 1);
            prefixArr[firstStrLength - i - 1] = prefix;
        }

        //   Arrays.stream(prefixArr).forEach(System.out::println);

        boolean[] matches = new boolean[strs.length - 1];
        //compare these prefixes on other strings
        for (int i = 0; i < prefixArr.length; i++) { //prefix loop
            String prefix = prefixArr[i];
            for (int j = 1; j < strs.length; j++) { // word loop
                String word = strs[j];
                if (word.startsWith(prefix)) {
                    matches[j - 1] = true;
                } else {
                    matches[j - 1] = false;
                }
            }

            boolean invalid = false;
            for (boolean match : matches) {
                if (!match) {
                    invalid = true;
                    break;
                }
            }
            if (!invalid) {
                return prefix;
            }
        }

        return "";
    }

    /**
     * Say you sort an array of words. The first word starts with a "b" and the last word also starts with a "b".
     * What does that tell you about all the words in between them?
     * They also all start with "b"! We know this because the words are sorted and the only way the first and last word
     * can both start with the same letter AND have the array be in order is if all the words in between start with the same letter.
     * Using this logic, if we sort our array of words we only ever have to look at the first and last one.
     * We can ignore all the middle words entirely since we know if the prefix matches for the first and last, it matches for the middle ones as well.
     * @param strs
     * @return
     */
    public String longestCommonPrefixOptimal(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

    public static void main(String[] args) {
        //String[] strs = {"flower", "flow", "flight"};
        //String[] strs = {"a"};
        //String[] strs = {"aaa", "aa", "aaa"};
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefixOptimal(strs));
    }
}
