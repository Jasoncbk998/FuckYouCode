import java.util.Arrays;
import java.util.HashMap;

public class _01 {
    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]   9-2=7
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[]{maps.get(target - nums[i]), i};
            }
            maps.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.sort(ints);
        for (int n : ints) {
            System.out.print(n + "\t");
        }
    }
}
