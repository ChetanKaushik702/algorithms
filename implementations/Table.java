import java.util.*;

public class Table {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long beg = System.currentTimeMillis();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.println(i + " X " + j + " = " + (i * j));
                }
                System.out.println();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - beg) / 1000.0);
        }
    }
}
