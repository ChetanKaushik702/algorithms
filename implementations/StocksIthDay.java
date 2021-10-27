import java.util.*;

public class StocksIthDay {
    static int stocks(int[] prices, int n, int R) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(prices[i], i + 1);
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int count = 0;

        for (Integer key : keys) {
            int C = key;
            int A = map.get(key);
            int P = Math.min(A, R / C);
            count += P;
            R -= P * C;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
        System.out.println(stocks(prices, n, k));
        sc.close();
    }
}
