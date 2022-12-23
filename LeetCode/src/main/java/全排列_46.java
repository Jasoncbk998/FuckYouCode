import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 视频题解
     * https://www.bilibili.com/video/BV1oa4y1v7Kz/?spm_id_from=333.337.search-card.all.click&vd_source=1abeaffdf7ae60d5e5fd119219c5edb9
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
//        枚举值
        ArrayList<Integer> list = new ArrayList<>();
//        记录使用过的元素
        boolean[] used = new boolean[n];
//        记录添加枚举数组的数量
        int count = 0;
        backtrace(list, used, count, nums);
        return lists;
    }

    /**
     * 回溯的经典思想,借助了一个辅助变量
     */
    public void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
//        当count等于数组长度,说明本次遍历已经完成,将子list add进入lists中
        if (count == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
//        深度优先遍历
//        查看本次遍历使用到了那个数字,如果使用了就true,回退后就false
        for (int i = 0; i < used.length; i++) {
//           used[i]=true 说明使用过
//           used[i]=false 说明没使用过
            if (!used[i]) {
//                添加元素,准备枚举
                list.add(nums[i]);
                used[i] = true;
                backtrace(list, used, count + 1, nums);
//                在这里需要注意,进入回溯之前做了什么,这里就需要进行一个逆操作
//               深度优先,进行回退
                list.remove(list.size() - 1);
//                清楚标记
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        全排列_46 temp = new 全排列_46();
        List<List<Integer>> permute = temp.permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }
}
