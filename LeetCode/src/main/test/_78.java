import java.util.ArrayList;
import java.util.List;

public class _78 {

    public static void main(String[] args) {
        _78 dp = new _78();
        int[] nums= {1,2,3};
        List<List<Integer>> subsets = dp.subsets(nums);
        System.out.println(subsets.toString());

    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if(cur==nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur+1,nums);
        t.remove(t.size()-1);
        dfs(cur+1,nums);
    }


}
