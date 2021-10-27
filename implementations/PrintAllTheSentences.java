import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllTheSentences {

    static void printAllSentences(ArrayList<ArrayList<String>> ll, int i, String sentence) {
        if (i == ll.size()) {
            System.out.println(sentence);
        } else {
            for (int j = 0; j < ll.get(i).size(); j++) {
                String word = ll.get(i).get(j);
                printAllSentences(ll, i + 1, sentence + word + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<String>> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] vals = sc.nextLine().split(" ");
            ArrayList<String> l = new ArrayList<>();
            for (String val : vals) l.add(val);
            ll.add(l);
        }

        printAllSentences(ll, 0, "");
        sc.close();
    }
}
