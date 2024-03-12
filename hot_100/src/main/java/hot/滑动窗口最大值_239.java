package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 滑动窗口最大值_239 {
    /**
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * @param nums
     * @param k
     * @return
     */
    // 这种写法,是正确的,但是太垃圾了,大批量数据跑不动
//    正确的做法是使用队列,进行计算,但是看不懂
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result_list = new ArrayList<Integer>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int end = start + k - 1;
            if (end >= nums.length) {
                continue;
            }
            int[] ints = Arrays.copyOfRange(nums, start, end + 1);
            Arrays.sort(ints);
            int max = ints[ints.length - 1];
            result_list.add(max);
            start += 1;
        }
        int[] result_array = new int[result_list.size()];
        for (int i = 0; i < result_list.size(); i++) {
            result_array[i] = result_list.get(i);
        }
        return result_array;
    }

    public static void main(String[] args) {
        滑动窗口最大值_239 test = new 滑动窗口最大值_239();
        int[] ints={1,3,-1,-3,5,3,6,7};
        int p=3;
        test.maxSlidingWindow(ints,p);

    }
}
