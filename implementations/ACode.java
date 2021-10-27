import java.io.*;
import java.util.HashMap;
import java.util.Map;


class ACode {

    static long countWays(int i, int n, String inp, Map<Integer, Long> dp) {
        if (i == n) return 1;
        if (dp.containsKey(i)) return dp.get(i);
        long count = 0;
        if (inp.charAt(i) != '0') {
            if (i < n - 1 && inp.charAt(i + 1) == '0')
                count = countWays(i + 2, n, inp, dp);
            else {
                count = countWays(i + 1, n, inp, dp);
                if (i < n - 1 && ((inp.charAt(i) == '1' && inp.charAt(i+1) <= '9') || (inp.charAt(i) == '2' && inp.charAt(i + 1) <= '6'))) {
                    count += countWays(i + 2, n, inp, dp);
                }
            }
        }
        dp.put(i, count);
        return count;
    }

    static long countWaysDriver(String inp) {
        Map<Integer, Long> dp = new HashMap<>();
        return countWays(0, inp.length(), inp, dp);
    }
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String inp = br.readLine();
                if (inp.equals("0"))    break;
                System.out.println(countWaysDriver(inp));
            }
        }
    }
}
