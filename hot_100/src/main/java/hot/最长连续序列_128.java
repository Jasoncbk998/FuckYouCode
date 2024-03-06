package hot;

import java.util.HashSet;

public class 最长连续序列_128 {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
//       最长连续长度
        int longestStreak = 0;
//        依次取出每一个元素,进行顺序比对
        for (int num : num_set) {
//    如果没有num-1的数字,则num为连续数组中的第一位元素,以num开始寻找连续数组元素
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
//                遍历set依次寻找 contains(currentNum + 1)
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
//                更新最大连续长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }


    public int longestConsecutive_1(int[] nums) {
        int max_Streak=0;
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum=num;
                int currentStreak=1;
                while (set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }

                max_Streak=Math.max(currentStreak,max_Streak);
            }
        }
        return max_Streak;


    }

    public static void main(String[] args) {
        最长连续序列_128 test = new 最长连续序列_128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = test.longestConsecutive_1(nums);
        System.out.println(i);

    }


}
