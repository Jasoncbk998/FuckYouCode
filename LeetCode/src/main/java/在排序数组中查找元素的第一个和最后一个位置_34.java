public class 在排序数组中查找元素的第一个和最后一个位置_34 {
    /**
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * <p>
     * 输入的数组是非递减排序的数组
     */
    public int[] searchRange(int[] nums, int target) {
        // 因为数组是非递减
        // 先找
        int l = search(nums, target);
        int r = search(nums, target + 1);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }

    /**
     * 这个二分查找思路简单,但是细节很满,需要多琢磨琢磨
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (r + l) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1};
        在排序数组中查找元素的第一个和最后一个位置_34 temp = new 在排序数组中查找元素的第一个和最后一个位置_34();
        int[] ints1 = temp.searchRange(ints, 1);
        System.out.println(ints.length);
        System.out.println(tools.printArray(ints1));

    }

}
