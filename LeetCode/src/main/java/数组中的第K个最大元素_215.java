import java.util.Random;

public class 数组中的第K个最大元素_215 {
    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        数组中的第K个最大元素_215 t = new 数组中的第K个最大元素_215();
        System.out.println(t.findKthLargest(nums, 1));
    }

    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int res = quickSelect(0, nums.length - 1, nums.length - k);
        return res;
    }

    private int quickSelect(int left, int right, int index) {
        // 找到分区点
        int q = randomPartition(left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(q + 1, right, index) : quickSelect(left, q - 1, index);
        }
    }

    // 以区间最后一个元素为锚点,依次进行比对分割,左侧比锚点小,右侧比锚点大
    private int randomPartition(int left, int right) {
        if (left >= right) {
            return left;
        }
        // 参考值
        int x = nums[right];
        // 分区边界,i是第一个不小于x的坐标,也就是左边界
        int i = left;
        for (int j = left; j < right; ++j) {
            if (nums[j] < x) {
                swap(nums, i, j);
                i += 1;
            }
        }
        // 最后,将参考值替换
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
