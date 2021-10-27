public class KMP {

    static int[] computeLPS(char[] str) {
        int[] lps = new int[str.length];
        int i = 1,
            j = 0;
        
        while (i < str.length) {
            if (str[i] == str[j]) { lps[i] = j + 1; i++; j++; }
            else {
                if (j == 0) { lps[i] = 0; i++; }
                else { j = lps[j - 1]; }
            }
        }

        return lps;
    }

    static void kmp (String T, String P) {
        char t[] = T.toCharArray();
        char p[] = P.toCharArray();

        int[] lps = computeLPS(p);

        int i = 0,
            j = 0;
        
        while (i <= t.length) {
            if (j == p.length) {
                System.out.println("Found pattern at index: " + (i - j));
                j = lps[j-1];
            }

            if (i == t.length)  break;

            if (t[i] == p[j]) { i++; j++; }
            else {
                if (j == 0) { i++; }
                else    { j = lps[j - 1]; }
            }
        }
    }

    public static void main(String[] args) {
        String T = "abcxabcdabxabcdabcdabcy";
        String P = "abcdabcy";

        kmp(T, P);
    }
}
