package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和_15 {
    /**
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 三数之和为0
     * <p>
     * <p>
     * 基本思想
     * 比如数组5个元素
     * 取出第一个元素,然后依次与2到4位元素依次做组合进行求和比较,相当于枚举出元素i=0的所有可能
     * 取出第二个元素,然后依次与3到4位元素依次做组合进行求和比较,相当于枚举出元素i=1的所有可能
     * ... ...
     * ...
     */
    public static List<List<Integer>> threeSum(int[] nums) {
//        存放结果
        ArrayList<List<Integer>> result = new ArrayList<>();
//        nums = [-1,0,1,2,-1,-4]
        Arrays.sort(nums); // 排序
//        -4,-1,-1,0,1,2
//        选定i元素,然后在i+1和nums.length重寻找是否存在另外两个数字,使三个数字相加的和为0
        for (int i = 0; i < nums.length; i++) {
            // 数组是升序,而题目求的是三数之和为0,如果第一个元素就已经大于0,那么直接返result即可,说明从i以后得元素均为正数(最小的元素是正数,那么这个数组中没有和为零的组合,所以直接返回)
            if (nums[i] > 0) {
                return result;
            }
            // 这里属于优化部分  相同数字直接contine
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 进行组合求和
            int left = i + 1; // 左边界
            int right = nums.length - 1; //右边界
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
//                    -4,-1,-1,0,1,2
//                如果sum>0,那么一定是num[right]偏大,所以向左移动一位,在进行计算(数字整体是由小到大进行排列)
                    right--;
                } else if (sum < 0) {
//                 如果sum<0,那么一定是num[left]偏大,所以向右移动一位,在进行计算(数字整体是由小到大进行排列)
                    left++;
                } else {
                    // 将三个元素添加到result中
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 因为排序后,按照大小顺序排列,所以在这里进行一次优化
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum_1(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum=nums[i]+nums[left]+nums[right];
                if (sum>0) {
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum_1(nums);
        System.out.println(lists);


    }
}
