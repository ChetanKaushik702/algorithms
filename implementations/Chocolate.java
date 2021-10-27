import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m, n;
            m = sc.nextInt();
            n = sc.nextInt();
            m--;
            n--;
            Integer[] x, y;
            x = new Integer[m];
            y = new Integer[n];

            for (int i = 0; i < m; i++) x[i] = sc.nextInt();
            for (int i = 0; i < n; i++) y[i] = sc.nextInt();

            Arrays.sort(x, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) { return b - a; }
            });
            Arrays.sort(y, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) { return b - a; }
            });
            
            int h = 1, v = 1;
            int cost = 0;

            int i = 0, j = 0;
            while (i < m && j < n) {
                if (x[i] > y[j]) {
                    cost += x[i] * v;
                    h++;
                    i++;
                } else {
                    cost += y[j] * h;
                    v++;
                    j++;
                }
            }

            int total = 0;
            while (i < m) total += x[i++];
            cost += total * v;

            total = 0;
            while (j < n) total += y[j++];
            cost += total * h;

            System.out.println(cost);

        }
        sc.close();
    }
}