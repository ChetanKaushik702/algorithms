import java.util.*;

public class LIS {

    static int lis(int[] arr, int n) {
        // O(n^2) approach
        int dp[] = new int[n];
        int res = 1;

        for (int i = 0; i < n; i++) {
            int val = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    val = Math.max(val, 1 + dp[j]);
                }
            }
            dp[i] = val;
            res = Math.max(res, dp[i]);
        }

        for (int state : dp)    System.out.print(state + " ");
        System.out.println();

        return res;
    }

    static int lisMoreOptimized(int[] arr, int n) {
        // O(nlgn) approach
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (seq.get(0) > arr[i])    seq.set(0, arr[i]);
            else if (seq.get(seq.size() - 1) < arr[i])  seq.add(arr[i]);
            else {
                int ceilIndex = ceilValueIndex(seq, arr[i]);
                seq.set(ceilIndex, arr[i]);
            }
            // System.out.println("i:" + i + "\tseq:" + seq);
        }

        return seq.size();
    }

    static int ceilValueIndex(ArrayList<Integer> values, int key) {
        int beg = 0, end = values.size() - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (values.get(mid) <= key)  beg = mid + 1;
            else    end = mid - 1;
        }
        return beg == values.size() ? -1 : beg;
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            int lisValue = lisMoreOptimized(arr, n);
            System.out.println(lisValue);
        }
    }
}
