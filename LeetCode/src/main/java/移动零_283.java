import java.awt.image.RGBImageFilter;
import java.util.HashSet;

public class 移动零_283 {

    public void moveZeroes(int[] nums) {
        int n = nums.length,left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        移动零_283 test = new 移动零_283();
        int[] nums = {0,1,0,3,12};
        test.moveZeroes(nums);
        tools.printArray(nums);
    }

}
