

public class 寻找重复数_287 {
    /**
     * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，返回这个重复的数
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     */
    public int findDuplicate(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        // 相当于码表
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        // 遍历
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}
