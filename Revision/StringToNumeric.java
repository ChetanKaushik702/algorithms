package Revision;

import java.util.Scanner;

public class StringToNumeric {
    static String[] keypad;

    static {
        keypad = new String[26];
        int ind = 0;
        for (int n = 2; n <= 9; n++) {
            if (n == 7 || n == 9) {
                ind = helper(keypad, ind, 4, n);
            } else {
                ind = helper(keypad, ind, 3, n);
            }
        }
    }

    static String numericString(String in, char ref) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            int ind = in.charAt(i) - ref;
            out.append(keypad[ind]);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numericString(s, 'A'));
        sc.close();
    }

    static int helper(String[] keypad, int ind, int times, int value) {
            StringBuilder str = new StringBuilder();
            for (int j = 1; j <= times; j++) {
                str.append(Integer.toString(value));
                keypad[ind++] = str.toString();
            }
            return ind;
    }
}
