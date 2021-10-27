import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        String n2 = sc.nextLine();

        System.out.println(Integer.toBinaryString(Integer.valueOf(n1, 2) * Integer.valueOf(n2, 2)));

        sc.close();
    }
}
