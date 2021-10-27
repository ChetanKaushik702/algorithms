import static java.lang.Math.*;

import java.util.Scanner;

public class InplaceMergeSort {

    static void mergeSort(int[] A, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    static void merge(int[] A, int l, int m, int r) {
        int n = (r - l + 1);
        int gap = (int)ceil(n / 2.0);

        while (gap > 0) {
            for (int i = l; i + gap < n; i++) {
                if (A[i] > A[i + gap]) {
                    // swap A[i] and A[i + gap]
                    A[i] = A[i] ^ A[i + gap];
                    A[i + gap] = A[i] ^ A[i + gap];
                    A[i] = A[i] ^ A[i + gap]; 
                }
            }
            if (gap == 1)   break;
            gap = (int)ceil(gap / 2.0);
        }
    }

    static void printArray(int[] A) {
        System.out.print("[");
        if (A.length > 0) {
            if (A.length == 0) {
                System.out.print(A[0] + "]");
            } else {
                System.out.print(A[0] + ", ");
                for (int i = 1; i <= A.length - 2; i++) {
                    System.out.print(A[i] + ", ");
                }
                System.out.println(A[A.length - 1] + "]");
            }
        } else {
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        printArray(A);
        mergeSort(A, 0, n - 1);
        printArray(A);
        sc.close();
    }

}