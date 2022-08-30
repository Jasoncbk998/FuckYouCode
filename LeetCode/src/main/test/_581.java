import java.util.Arrays;

public class _581 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        System.out.println(tools.printArray(Arrays.copyOfRange(nums, left, right+1)));
        return right == -1 ? 0 : right - left + 1;

    }

    public static void main(String[] args) {
        _581 temp = new _581();
        int[] ints = {2, 6, 4, 15};
        int unsortedSubarray = temp.findUnsortedSubarray(ints);


    }

}
