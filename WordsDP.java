import java.util.*;

public class WordsDP {
    static Map<Integer, String> dp = new HashMap<>();
    static int f(int i, int n, String s, String inp) {
        if (i == n) {
            System.out.println(s);
            return 1;
        }
        if (dp.containsKey(i)) {
            String val[] = dp.get(i).split(" ");
            Integer count = Integer.parseInt(val[0]);
            System.out.println("c: " + val[1]);
            System.out.println("s: " + s);
            return count;
        }
        int count = 0;
        if (inp.charAt(i) != '0') {
            if (i < n - 1 && inp.charAt(i + 1) == '0') {
                count = f(i + 2, n, s + inp.charAt(i) + inp.charAt(i+1), inp);
            }
            else {
                count = f(i + 1, n, s + inp.charAt(i), inp);
                if (i < n - 1 && ((inp.charAt(i) == '1' && inp.charAt(i+1) <= '9') || (inp.charAt(i) == '2' && inp.charAt(i + 1) <= '6'))) 
                    count += f(i + 2, n, s + inp.charAt(i) + "-" + inp.charAt(i + 1), inp);
            }
        }
        dp.put(i, count + " " + s);
        return count;
    }
    public static void main(String[] args) {
        String inp = "3333333333";
        System.out.println(f(0, inp.length(), "", inp));
    }
}
