import java.io.*;
import java.util.*;

public class Codechef {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String[] s = br.readLine().split(" ");
                long l = Long.parseLong(s[0]);
                long r = Long.parseLong(s[1]);

                while (l % 3 != 0)  l++;
                while (r % 3 != 0)  r--;

                long n = (r - l) / 3 + 1;
                System.out.println(n);
            }
        }
    }
}
