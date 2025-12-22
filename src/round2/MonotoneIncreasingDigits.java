package round2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        MonotoneIncreasingDigits instance = new MonotoneIncreasingDigits();
        System.out.println(instance.monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int n) {
        //从后向前遍历，遇到nums[i-1]>nums[i] -> nums[i-1]--, nums[i]=9
        //还需要标记从哪里开始赋值为9
        List<Integer> nums = new ArrayList<>();


        while (n / 10 != 0) {
            nums.add(n % 10);
            n /= 10;
        }

        nums.add(n % 10);
        nums = nums.reversed();
        int flag = nums.size();//这里初始值要为最大值

        for (int i = nums.size() - 1; i >= 1; i--) {
            if (nums.get(i - 1) > nums.get(i)) {
                nums.set(i - 1, nums.get(i - 1) - 1);
                flag = i;
            }
        }

        for(int i = flag; i<nums.size(); i++){
            nums.set(i, 9);
        }


        String string = nums.stream().map(String::valueOf).collect(Collectors.joining());
        return Integer.parseInt(string);
    }
}
