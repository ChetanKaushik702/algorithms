import java.util.Scanner;

public class TernarySearch {

    static int ternarySearch (int[] A, int val) {
        int beg = 0, end = A.length - 1;
        while (beg <= end) {
            int m1 = beg + (end - beg) / 3;
            int m2 = end - (end - beg) / 3;
            if (A[m1] == val)   return m1;
            if (A[m2] == val)   return m2;
            if (A[m1] > val)    end = m1 - 1;
            else if (A[m2] < val)   beg = m2 + 1;
            else {
                beg = m1 + 1;
                end = m2 - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        int val = sc.nextInt();
        int index = ternarySearch(A, val);
        System.out.println(index);
        sc.close();
    }
}
