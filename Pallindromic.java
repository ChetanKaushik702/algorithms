import java.util.Scanner;

public class Pallindromic {

    static void printPall(String s) {
        for (int j = 0; j < s.length(); j++) {
            for (int i = j + 1; i <= s.length(); i++) {
                String p = s.substring(j, i);
                if (isPallindrome(p))   System.out.println(p);
            }
        }
    }

    static boolean isPallindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printPall(s);
        sc.close();
    }
}
