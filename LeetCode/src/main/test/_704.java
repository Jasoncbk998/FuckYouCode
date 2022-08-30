public class _704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 1 2 5 2 3
            int mid = (right - left) / 2 + right;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid + 1;
            } else {
                left = mid - 1;
            }
        }
        return -1;
    }
}
