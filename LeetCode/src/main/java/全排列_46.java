import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    /**
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        int count = 0;
        backtrace(list, used, count, nums);
        return lists;
    }

    /**
     * 回溯的经典思想,借助了一个辅助变量
     */
    public void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
        if (count == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrace(list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        全排列_46 temp = new 全排列_46();
        List<List<Integer>> permute = temp.permute(new int[]{1, 2});
        System.out.println(permute.toString());


    }
}
