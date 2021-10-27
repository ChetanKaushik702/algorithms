import java.util.Arrays;

public class LongestPallindrome {

    static String result;
    
    static int solve(String s, int i, int j, String s1, String s2) {
        // System.out.println(i + "\t" + j + "\t" + s1 + "\t" + s2);
        if (i >= j) {
            String res = s1;
            if (i == j) res += s.charAt(i);
            res += s2;
            // System.out.println(res + "\t" + res.length());
            if (result.length() < res.length()) result = res;
            return res.length();
        } 

        if (s.charAt(i) == s.charAt(j)) {
            return solve(s, i + 1, j - 1, s1 + s.charAt(i), s.charAt(j) + s2);
        }

        int val1 = solve(s, i + 1, j, s1, s2);
        int val2 = solve(s, i, j - 1, s1, s2);

        return val1 > val2 ? val1 : val2;
    }

    public static void main(String[] args) {
        // String s = "saforgeeksskeegrofas";
        String s = "babad";
        // result = "";
        // solve(s, 0, s.length() - 1, "", "");
        // System.out.println(result);
        botUp(s.toCharArray());
    }

    static void botUp(char s[]) {
        int dp[][] = new int[s.length][s.length];
        int maxLen = 1, beg = 0, end = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = dp.length - 1; j >= i; j--) {
                boolean flag = true;
                if (s[i] == s[j]) {
                    int ti = i, tj = j;
                    while (ti <= tj) {
                        if (s[ti] != s[tj]) {
                            flag = false;
                            break;
                        }
                        dp[ti][tj] = 1;
                        ti++;
                        tj--;
                    }
                    if (flag) {
                        if (maxLen < (j - i + 1)) {
                            maxLen = j - i + 1;
                            beg = i;
                            end = j;
                        }
                    }
                }
            }
        }
        for (int[] val : dp) {
            for (int state : val) {
                System.out.print(state + " ");
            }
            System.out.println();
        }
        System.out.println("maxLen: " + maxLen + "\tbeg: " +beg + "\tend: " + end);
        System.out.println(new String(Arrays.copyOfRange(s, beg, end+1)));
    }
}
