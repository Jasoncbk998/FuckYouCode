import java.util.ArrayList;
import java.util.List;

public class 子集_78 {
    /**
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     * [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
     * 先 add 1 然后 进入dfs 从index=1开始 add 2 在进入dfs 从index=2 开始 add 3 自此  1,2,3 找到了
     * 然后 t中移除最后一个元素 也就是剩下1,2
     */
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            // 将t add进入list
            ans.add(new ArrayList<Integer>(t));
            return;
        }

        t.add(nums[cur]);
        // 再度搜索
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        子集_78 dp = new 子集_78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = dp.subsets(nums);
    }
}
