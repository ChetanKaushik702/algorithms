import java.util.ArrayList;

public class RecursionGFG {
    static final int MOD = (int)1e9 + 7;
    static int count;
    static long N;
    static ArrayList<String> list;
    static void compute(int i, String state) {
        // System.out.println(state);
        // list.add(state);
        if (i > 9 || (!state.isEmpty() && Long.parseLong(state) > N)) return; 
        count = (count + 1) % MOD;
        for (int j = i; j <= 9; j++) {
            String newState = state + j;
            compute(j, newState);
        }
    }
    public static void main(String[] args) {
        N = (long)5e17;
        count = 0;
        list = new ArrayList<>();
        compute(1, "");
        System.out.println(count);
        System.out.println(list);
    }
}
