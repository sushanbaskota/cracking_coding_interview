public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("h   h"));
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        String[] ss = s.split("\\s+");
        int lastWordStartIndex = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            char currentLetter = s.charAt(i);
            char prevLetter = s.charAt(i - 1);

            if (currentLetter != ' ' && prevLetter == ' ') {
                lastWordStartIndex = i;

                break;
            }
        }

        String lastWord = s.substring(lastWordStartIndex).trim();

        return lastWord.length();
    }
}
