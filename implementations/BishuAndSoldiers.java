import java.util.*;

public class BishuAndSoldiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] powers = new int[N];
        int[] prefix = new int[N];
        for (int i = 0; i < N; i++) {
            powers[i] = sc.nextInt();
            if (i == 0) prefix[i] = powers[i];
            else    prefix[i] = prefix[i-1] + powers[i];
        }
        Arrays.sort(powers);
        int Q = sc.nextInt();
        while (Q-- > 0) {
            int M = sc.nextInt();
            int kills = countKills(powers, M);
            if (kills == 0) {
                System.out.println(kills + " " + 0);
            } else {
                System.out.println(kills + " " + prefix[kills - 1]);
            }
        }
        sc.close();
    }

    static int countKills(int[] powers, int M) {
        int beg = 0, end = powers.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (powers[mid] > M)    end = mid - 1;
            else    beg =  mid + 1;
        }
        return beg;
    }
}
