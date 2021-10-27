import java.util.HashSet;
import java.util.Scanner;

public class WordBreakBackTracking {
    static void wordBreak(String s, int i, String ans, HashSet<String> words) {
        if (i == s.length()) {
            System.out.println(ans);
        } else {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                if (words.contains(word)) {
                    wordBreak(s, j + 1, ans + word + " ", words);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < n; i++) words.add(sc.nextLine());
        System.out.println(words);
        String s = sc.nextLine();
        wordBreak(s, 0, "", words);
        sc.close();
    }
}
