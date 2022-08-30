public class 最短无序连续子数组_581 {
    /**
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 请你找出符合题意的 最短 子数组，并输出它的长度
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序
     *
     * 基本思路
     * 一次循环,找到无序子数组中的最大最小值在数组中的正确位置
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        // 不断寻找,无序子数组中的最小值的正确位置以及正确的最大位置
        // max位置和min位置确定了范围
//        2,6,4,8,10,9,15
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                //不断找到无序子数组中最大值的正确位置
                right = i;
            } else {
                // 更新最大值
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                // 找到无序子数组中的最小值的正确位置
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        最短无序连续子数组_581 temp = new 最短无序连续子数组_581();
        int unsortedSubarray = temp.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        System.out.println(unsortedSubarray);

    }
}
