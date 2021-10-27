import java.util.Scanner;

public class Median {

    static double getMedian(int[] s1, int[] s2) {
        double median = 0;

        if (s2.length < s1.length) {
            int[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int start = 0, end = s1.length;
        while (start <= end) {
            int pX = (start + end) >> 1;
            int pY = ((s1.length + s2.length + 1) >> 1) - pX;

            int minRX = pX >= s1.length ? Integer.MAX_VALUE : s1[pX], minRY = pY >= s2.length ? Integer.MAX_VALUE : s2[pY];
            int maxLX = pX <= 0 ? Integer.MIN_VALUE : s1[pX - 1], maxLY = pY <= 0 ? Integer.MIN_VALUE : s2[pY - 1];

            // s1[0...pX-1] and s2[0...pY-1]        s1[pX...s1.length-1] and s2[pY...s2.length -1]


            // System.out.println("pX: " + pX + "\tpY: " + pY);
            // System.out.println("maxLX: " + maxLX + "\tminRX: " + minRX);
            // System.out.println("maxLY: " + maxLY + "\tminRY: " + minRY);

            // condition for median
            if (maxLX > minRY) {
                end = pX - 1;
            }
            else if (maxLY > minRX) {
                start = pX + 1;
            }
            else {
                if ((s1.length + s2.length) % 2 == 0 ) {
                    median = (Math.max(maxLX, maxLY) + Math.min(minRX, minRY)) / 2.0;
                } else {
                    median = Math.max(maxLX, maxLY);
                }
                break;
            } 
        } 

        return median;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] s1, s2;
        s1 = new int[n1];
        s2 = new int[n2];

        for (int i = 0; i < n1; i++)    s1[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)    s2[i] = sc.nextInt();

        System.out.println(getMedian(s1, s2));
        sc.close();
    }
}

/* 
    [1,2,3,4] and [5,6,7,8]
    b   e   m
    0   4   2   s1[0...1]   and    s2[0...1]
    3   4   3   [1,2,3], [5]    |   [4], [6,7,8]
    4   4   4   [1,2,3,4]   |   [5,6,7,8] 
    
    [5,6,7,8]   and     [1,2,3,4]
    b   e   m 
    0   4   2   [5,6], [1,2] | [7,8], [3,4]
    0   1   0   [1,2,3,4]   |   []
                    []      |    [5,6,7,8]

    [1,2,4] and [3,5,6,7]
    b   e   m
    0   3   1   [1]     |   [2,4]
                [3,5,6] |   [7]
    2   3   2   [1,2]   |   [4]
                [3,5]   |   [6,7]
    3   3   3   [1,2,4] |   []
                [3]     |   [5,6,7]
*/