import java.util.Scanner;

public class ProBending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int val = 0;
        for (int i = 0; i < n; i++) val = Math.max(val, sc.nextInt());
        if (k > val) System.out.println("Easy Win!");
        else    System.out.println("Difficult Loss");
        sc.close();
    }
}
