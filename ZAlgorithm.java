import java.util.ArrayList;

public class ZAlgorithm {

    int[] calculateZ(String str) {
        int[] z = new int[str.length()];
        int left = 0, right = 0;
        for (int k = 1; k < str.length(); k++) {
            if (k > right) {
                left = right = k;
                while (right < str.length() && str.charAt(right) == str.charAt(right - left))
                    right++;
                z[k] = right - left;
                right--;
            }
            else {
                int kl = k - left;
                if (z[kl] < right - k + 1) {
                    z[k] = z[kl];
                } 
                else {
                    left = k;
                    while (right < str.length() && str.charAt(right) == str.charAt(right - left))
                        right++;
                    z[k] = right - left;
                    right--;
                }
            }
        }
        return z;
    }

    ArrayList<Integer> stringMatching(String txt, String pat) {
        ArrayList<Integer> res = new ArrayList<>();
        String str = pat + "$" + txt;
        int[] z = calculateZ(str);
        // for (int v : z) System.out.print(v + " ");
        // System.out.println();

        for (int i = pat.length() + 1; i < str.length(); i++) {
            if (z[i] == pat.length())
                res.add(i - pat.length() - 1);
        }

        return res;
    }
    public static void main(String[] args) {
        String txt = "abcxabcb";
        String pat = "abc";

        ZAlgorithm zAlgorithm = new ZAlgorithm();
        ArrayList<Integer> out = zAlgorithm.stringMatching(txt, pat);
        System.out.println(out);

    }
}
