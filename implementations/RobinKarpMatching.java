public class RobinKarpMatching {
    
    static void robinKarpMatch (String T, String P, int d, int q) {
        int n = T.length(),
            m = P.length(),
            h = (int)Math.pow(d, m - 1) % q,
            p = 0,
            t = 0;
        
        // preprocessing
        for (int i = 0; i < m; i++) {
            p = (d * p + P.charAt(i)) % q;
            t = (d * t + T.charAt(i)) % q;
        }

        // matching
        for (int s = 0; s <= n - m; s++) {
            if (p == t) {
                if (T.substring(s, s + m).equals(P)) {
                    System.out.println("Pattern occurs with shift: " + s);
                }
            }
            if (s < n - m) {
                t = (d * (t - T.charAt(s) * h) + T.charAt(s + m)) % q;
            }
        }
    }

    public static void main(String[] args) {
        int q = (int)1e9 + 7;
        int d = 10;
        String T = "AABAACAADAABAABA";
        String P = "AABA";

        robinKarpMatch(T, P, d, q);
        
    }
}
