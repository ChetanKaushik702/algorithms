import java.util.*;
public class GameWithString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            boolean flag = true;
            while (!stack.isEmpty() && stack.peekLast() == ch) {
                count++;
                flag = false;
                stack.pollLast();
            }
            if (flag)   stack.offerLast(ch);
        }
        if (count % 2 == 0) System.out.println("No");
        else    System.out.println("Yes");
        sc.close();
    }
}