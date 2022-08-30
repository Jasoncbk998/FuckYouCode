import java.util.HashSet;

public class 最长连续序列_119 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4
     */
    public int longestConsecutive(int[] nums) {
        // 使用hashset 忽略排列位置
        HashSet<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            // 如果存在num-1的元素,那么就说明该元素不是连续序列的起点
            if (!sets.contains(num - 1)) {
                // 记录比较元素,从这个元素开始往后找
                int currentNum = num;
                // 连续步长
                int currentStreak = 1;
                // 不断查找是否有currentNum + 1元素
                while (sets.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;

    }
}
