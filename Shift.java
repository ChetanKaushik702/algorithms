import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shift {

    public static void rearrange(List<Integer> nums)
	{
		int neg = nums.size(), i = 0;
		while (i < neg) {
			if (nums.get(i) > 0) {
				i++;
			} else {
				int temp = nums.get(neg - 1);
				nums.set(neg - 1, nums.get(i));
				nums.set(i, temp);
				neg--;
			}
		}
        System.out.println("nums: " + nums);
		i = 1;
		while (neg < nums.size() && i < nums.size()) {
			int temp = nums.get(neg);
			nums.set(neg, nums.get(i));
			nums.set(i, temp);
			i += 2;
			neg++;
		}
	}
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) nums.add(sc.nextInt());

        rearrange(nums);
        System.out.println(nums);
        sc.close();
    }
}
