import java.util.Scanner;

public class MooreMajorityElement {

    static int majorityElement (int[] A) {
        int ele = A[0],
            count = 1;
        for (int i = 1; i < A.length; i++) {
            if (ele != A[i]) {
                count--;
                if (count == 0) {
                    ele = A[i];
                    count = 1;
                }
            }
        }

        // verification
        int freq = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == ele)    freq++;
        }

        return freq > A.length / 2 ? ele : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        System.out.println(majorityElement(A));
        sc.close();
    }
}
