package Revision;
public class Demo {
    static void f(int[] a, int i, int sum, String s) {
        if (i == a.length) {
            if (sum == 0) {
                System.out.println(s);
                return;
            }
        }
        if (sum < 0)    return;
        if (i < a.length) {
            f(a, i, sum - a[i], s + a[i] + ", ");
            f(a, i + 1, sum, s);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4, 7};
        f(a, 0, 7, "");
    }
}
