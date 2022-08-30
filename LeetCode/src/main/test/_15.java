import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[right], nums[left]));
                    while (left > right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left > right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -2, 2, 2, -2, 2, -3, 4, 3};
        List<List<Integer>> lists = threeSum(ints);
        System.out.println(lists.toString());
    }
}
