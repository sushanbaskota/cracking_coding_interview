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

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        //String[] strs = {"a"};
        //String[] strs = {"aaa", "aa", "aaa"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
