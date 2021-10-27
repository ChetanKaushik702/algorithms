public class Interleaving {
    static void printAllInter(String a, String b, int i, int j, String out) {
        if (i == a.length() && j == b.length()) {
            System.out.println(out);
            return;
        }
        if (i < a.length()) printAllInter(a, b, i+1, j, out + a.charAt(i));
        if (j < b.length()) printAllInter(a, b, i, j+1, out + b.charAt(j));
    }

    public static void main(String[] args) {
        String a = "BCC";
        String b = "BBCA";
        printAllInter(a, b, 0, 0, "");
    }
}
