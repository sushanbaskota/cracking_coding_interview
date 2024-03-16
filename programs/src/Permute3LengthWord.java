public class Permute3LengthWord {
    public static void main(String[] args) {
        permute3("abc");
    }

    /**
     * In permutation the char index for any word of new string should be unique to other char
     * here is the example for "abc"
     * [abc] [acb] [bac] [bca] [cab] [cba]
     * [012] [021] [102] [120] [201] [210]   <= these are index of each char, see all of them are unique on each word
     * in below iterative approach for permutation, we are just trying to nest loop times of word length
     * and find the index where all are unique, and ignore matching index
     * --The problem with iterative approach is the nested level keeps on growing with word length so its not
     * feasible, these are the use case where recursive approach best suits, also in this approach you have to know the
     * length of letter on advance to find the nest depth level--
     */
    private static void permute3(String word) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue; //ignore
                }
                for (int k = 0; k < 3; k++) {
                    if (k == j || k == i) {
                        continue; //ignore
                    }
                    System.out.println("[" + word.charAt(i) + " " + word.charAt(j) + " " + word.charAt(k) + "]");
                }
            }
        }
    }
}
